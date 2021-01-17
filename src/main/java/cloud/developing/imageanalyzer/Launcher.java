package cloud.developing.imageanalyzer;

import org.json.JSONObject;

import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.stepfunctions.AWSStepFunctions;
import com.amazonaws.services.stepfunctions.AWSStepFunctionsClientBuilder;
import com.amazonaws.services.stepfunctions.model.StartExecutionRequest;

import cloud.developing.imageanalyzer.model.S3Object;

public class Launcher {

	private final AWSStepFunctions stf = AWSStepFunctionsClientBuilder.defaultClient();

	private final static String STATE_MACHINE_ARN = System.getenv("STATE_MACHINE_ARN");

	public void launch(S3Event event) throws Exception {
		for (var record : event.getRecords()) {
			var s3 = record.getS3();
			var jsonToStart = new JSONObject(new S3Object(s3.getBucket().getName(), s3.getObject().getKey()))
					.toString();

			stf.startExecution(
					new StartExecutionRequest().withInput(jsonToStart).withStateMachineArn(STATE_MACHINE_ARN));
		}
	}

}
