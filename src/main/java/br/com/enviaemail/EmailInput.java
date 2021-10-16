package br.com.enviaemail;

public class EmailInput {

	private String para;
	private String corpo;
	private String assunto;

	public EmailInput(String para, String corpo, String assunto) {
		this.para = para;
		this.corpo = corpo;
		this.assunto = assunto;
	}

	public String getPara() {
		return para;
	}

	public String getCorpo() {
		return corpo;
	}

	public String getAssunto() {
		return assunto;
	}

}
