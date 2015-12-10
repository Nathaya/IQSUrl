package com.iqs.source;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="openUrl")
@SessionScoped
public class OpenUrl {
	
	 private int projtype =1;
	 private int envtype=1;
	 private String error;

	public int getProjtype() {
			return projtype;
		}

		public void setProjtype(int projtype) {
			this.projtype = projtype;
		}
		 
		
	 public int getEnvtype() {
			return envtype;
		}

		public void setEnvtype(int envtype) {
			this.envtype = envtype;
		}
		

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}
		
	
		public void choiceUrl(){
			
			if (envtype == 1){
				try {
					if (projtype == 6){
						int count = projtype;
						for (int i = 1; i < count; i++) {
							projtype = i;
							callProd();
						}
						projtype = count;
					}else{
						callProd();
						setError(" ");
					}
				} catch (Exception NullPointerException) {
					// TODO Auto-generated catch block
					setError("**Have no data in Table!!");
				}
			}else if (envtype == 2){
				try {
					if (projtype == 6){
						int count = projtype;
						for (int i = 1; i < count; i++) {
							projtype = i;
							callTest();
						}
						projtype = count;
					}else{
						callTest();
						setError(" ");
					}
				} catch (Exception NullPointerException) {
					// TODO Auto-generated catch block
					setError("**Have no data in Table!!");
				}
			}

    	}
		
		public void callProd() throws IOException{
	
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("initialdata.properties");
			Properties config = new Properties();
			config.load(in); 
			String uri;
			switch (projtype) {
            case 1:  uri = config.getProperty("prod.shin");
                     break;
            case 2:  uri = config.getProperty("prod.nhlbi");
                     break;
            case 3:  uri = config.getProperty("prod.ninds");
                     break;
            case 4:  uri = config.getProperty("prod.nimh");
                     break;
            case 5:  uri = config.getProperty("prod.pinnacle");
                     break;
            default: uri = null;
            		break;
			}
			OpenUrl browse = new OpenUrl();
			browse.callUrl(uri);
		}
		public void callTest() throws IOException{
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("initialdata.properties");
			Properties config = new Properties();
			config.load(in); 
			String uri;
			switch (projtype) {
            case 1:  uri = config.getProperty("test.shin");
                     break;
            case 2:  uri = config.getProperty("test.nhlbi");
                     break;
            case 3:  uri = config.getProperty("test.ninds");
                     break;
            case 4:  uri = config.getProperty("test.nimh");
                     break;
            case 5:  uri = config.getProperty("test.pinnacle");
                     break;
            default: uri = null;
            		break;
			}
			OpenUrl browse = new OpenUrl();
			browse.callUrl(uri);
		}


	
	public void callUrl(String url) {
		try {
		//System.out.println("Test1");
			Desktop.getDesktop().browse(new URL(url).toURI());
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
		
		
		 

