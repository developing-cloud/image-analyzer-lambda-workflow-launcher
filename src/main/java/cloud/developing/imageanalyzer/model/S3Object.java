package cloud.developing.imageanalyzer.model;

public class S3Object {

	private String bucket, name;

	public S3Object(String bucket, String name) {
		this.bucket = bucket;
		this.name = name;
	}

	public S3Object() {
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
