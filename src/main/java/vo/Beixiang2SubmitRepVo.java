package vo;


import java.util.List;

public class Beixiang2SubmitRepVo {
	
	private List<SmsBody> CmcSmsBody;

	public List<SmsBody> getCmcSmsBody() {
		return CmcSmsBody;
	}

	public void setCmcSmsBody(List<SmsBody> cmcSmsBody) {
		CmcSmsBody = cmcSmsBody;
	}

	@Override
	public String toString() {
		return "Beixiang2SubmitRepVo{" +
				"CmcSmsBody=" + CmcSmsBody +
				'}';
	}
}

