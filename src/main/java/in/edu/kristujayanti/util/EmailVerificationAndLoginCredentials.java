package in.edu.kristujayanti.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.services.sesv2.model.Destination;
import software.amazon.awssdk.services.sesv2.model.EmailContent;
import software.amazon.awssdk.services.sesv2.model.SendEmailRequest;
import software.amazon.awssdk.services.sesv2.model.SesV2Exception;
import software.amazon.awssdk.services.sesv2.SesV2Client;
import software.amazon.awssdk.services.sesv2.model.Template;

public class EmailVerificationAndLoginCredentials {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailVerificationAndLoginCredentials.class);

    private final Properties emailProperties;
    protected static final String TEMPLATE_NAME = "MyTemplate";
    protected static final String REGION = "AP_SOUTH_1";

    public EmailVerificationAndLoginCredentials() {
        this.emailProperties = loadEmailProperties();
    }

    private Properties loadEmailProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("aws_config.properties")) {
            if (input == null) {
                LOGGER.error("Unable to find aws_config.properties");
                return properties;
            }
            properties.load(input);
        } catch (IOException ex) {
            LOGGER.error("Error loading aws properties", ex);
        }
        return properties;
    }

    protected AwsBasicCredentials loadAwsCredentials() throws IOException {
        return AwsBasicCredentials.create(this.emailProperties.getProperty("aws.accessKeyId"), this.emailProperties.getProperty("aws.secretKey"));
    }

    protected static SesV2Client initializeSesV2Client(AwsBasicCredentials awsCreds) {
        return SesV2Client.builder()
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();
    }
    /**
     * Sends an email based on a template using the specified client, sender, recipient, and template name.
     * @param templateData The template data
     * @param recipient    The recipient's email address.
     * @param templateName The name of the email template.
     */
    public void sendEmail(String recipient, String templateName, String templateData ) {
        try {
            AwsBasicCredentials awsCreds = loadAwsCredentials();
            SesV2Client client = initializeSesV2Client(awsCreds);
            String sender = this.emailProperties.getProperty("aws.email");
            send(client, sender, recipient, templateName, templateData);
        } catch (IOException e) {
            LOGGER.error("Error initializing AWS credentials", e);
        }
    }

    protected static void send(SesV2Client client, String sender, String recipient, String templateName, String templateData) {
        Destination destination = Destination.builder()
                .toAddresses(recipient)
                .build();

        Template myTemplate = Template.builder()
                .templateName(templateName)
                .templateData(templateData)
                .build();

        EmailContent emailContent = EmailContent.builder()
                .template(myTemplate)
                .build();

        SendEmailRequest emailRequest = SendEmailRequest.builder()
                .destination(destination)
                .content(emailContent)
                .fromEmailAddress(sender)
                .build();

        try {
            LOGGER.info("Attempting to send an email based on a template using the AWS SDK for Java (v2)...");
            client.sendEmail(emailRequest);
            LOGGER.info("Email based on a template was sent.");
        } catch (SesV2Exception e) {
            LOGGER.error(e.awsErrorDetails().errorMessage());

        }
    }
}
