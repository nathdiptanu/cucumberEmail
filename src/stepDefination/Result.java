package stepDefination;

public class Result {
	
	private String result;
	private String resultText;
	private long time;
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public Result(String result,String resultText,long time) {
		this.result = result;
		this.resultText = resultText;
		this.time = time;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public void setResultText(String resultText) {
		this.resultText = resultText;
	}
	
	public String getResultText() {
		return this.resultText;
	}	
}