package top.magiczjk.bean;

import java.io.Serializable;

public class ResultBean implements Serializable{
		

	private static final long serialVersionUID = -1819492582740591514L;
	private boolean error;
	private Object results;
	
	
	
	public ResultBean(boolean error, Object results) {
		super();
		this.error = error;
		this.results = results;
	}
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public Object getResults() {
		return results;
	}
	public void setResults(Object results) {
		this.results = results;
	}
	
	
}
