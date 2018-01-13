package com.dev.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.dev.bean.ApplicantDetails;
import com.dev.resources.Factory;

import test.JobPage;

public class ApplyForJob extends JFrame{
	
	private static final Logger LOGGER = Logger.getLogger(JobPage.class);
	private JPanel contentPane;
	private JButton apply;
	private JTextField resumePath;
	private JFileChooser jFileChooser;
	private JLabel successMessage;
	private String message = "";
	private JButton home ;
	static ApplyForJob applyFrame;
	
	public ApplyForJob(final String jc) {
		setResizable(true);
		setTitle("Job Portal...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
	    
	    JPanel contentPane1 = new JPanel(null); 
	    

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xFFFFFF));
		contentPane.setForeground(new Color(0x000080));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		
		JLabel applyForJob = new JLabel("Upload your Resume");
		applyForJob.setForeground(new Color(0x000080));
		applyForJob.setBounds(screenSize.width/2-200, 60, 500, 50);
		applyForJob.setFont(new Font("Verdana",Font.BOLD,26));
		contentPane.add(applyForJob);
		
		home = new JButton("Home");
		
		home.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try{
				        		HomePage.frame = new HomePage(null);
				        		HomePage.frame.setVisible(true);
				                setVisible(false);
				            }catch(Exception e1){
				            	LOGGER.error("\nException Occured: "+e1.getMessage());
								LOGGER.error(e1.getMessage(), e1);
				            }
					}
			});
		home.setBackground(new Color(0xFFFFFF));
		home.setForeground(new Color(0x000080));
		home.setBorderPainted(false);
		home.setFont(new Font("Verdana",Font.BOLD,16));
		home.setBounds(screenSize.width-screenSize.width/5, 60, 89, 30);
		contentPane.add(home);
		
		JLabel JCLabel1 = new JLabel("Resume:");
		JCLabel1.setForeground(new Color(0x000080));
		JCLabel1.setBounds(screenSize.width/4, screenSize.height/2-100, 200, 50);
		JCLabel1.setFont(new Font("Verdana",Font.BOLD,20));
		contentPane.add(JCLabel1);
		
		
		
		resumePath = new JTextField();
		resumePath.setColumns(10);
		resumePath.setBounds(screenSize.width/4+220, screenSize.height/2-90, 400, 30);
		resumePath.setFont(new Font("Verdana",Font.PLAIN,16));
		contentPane.add(resumePath);
		resumePath.setColumns(10);
		jFileChooser = new JFileChooser();
		home = new JButton("Browse");
		home.setBackground(new Color(0x000080));
		home.setForeground(new Color(0xFFFFFF));
		home.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							 if (e.getSource() == home) {
							        int returnVal = jFileChooser.showOpenDialog(ApplyForJob.this);
					
							        if (returnVal == JFileChooser.APPROVE_OPTION) {
							            File file = jFileChooser.getSelectedFile();
							            String traineeListPath=file.getAbsolutePath();
							            traineeListPath=traineeListPath.replace("\\", "/");
							            resumePath.setText(traineeListPath);
							            
										LOGGER.info("Trainee List Path entered is:["+traineeListPath+"]");
							        } else {
							        	LOGGER.info("Open command has been cancelled");
							        }
						}
					}
			});
		home.setBounds(screenSize.width/4+620, screenSize.height/2-90, 89, 30);
		contentPane.add(home);
		
		
		apply = new JButton("Apply for Job");
		apply.setBounds(screenSize.width/2-200, screenSize.height/2, 200, 30);
		apply.setBackground(new Color(0x000080));
		apply.setForeground(new Color(0xFFFFFF));
		apply.setFont(new Font("Verdana",Font.PLAIN,16));
		contentPane.add(apply);
		
		
		successMessage = new JLabel("");
		successMessage.setBounds(screenSize.width/4, screenSize.height/2+100, 700, 100);
		successMessage.setFont(new Font("Verdana",Font.PLAIN,24));
		successMessage.setForeground(new Color(0x12650A));
		contentPane.add(successMessage);
		
		
		
		apply.addActionListener( new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e)
	            {
		        	try{
		                ApplicantDetails details = new ApplicantDetails();
		                details.setName("abc");
		                
		                details.setJob(jc);
		                details.setResume(convertPathToByteArray(resumePath.getText()));
						message = Factory.createApplicantService().applyForJob(details);
						successMessage.setText(message);
		            }catch(Exception e1){
		            	LOGGER.error("\nException Occured: "+e1.getMessage());
						LOGGER.error(e1.getMessage(), e1);
		            }
	            
	            }

			private byte[] convertPathToByteArray(String path) throws IOException {
				
				String pathCorrected = path.replace("\\", "//");
				
				File newpdf = new File(pathCorrected);
			 	
		        FileInputStream fis = new FileInputStream(newpdf);
		        ByteArrayOutputStream baos= new ByteArrayOutputStream();
		        byte[] buff = new byte[2048000];
		        for(int readNum; (readNum=fis.read(buff)) !=-1 ; ){
		            baos.write(buff,0,readNum);
		        }
				return baos.toByteArray();
			}
	    });
		
		
		
		JScrollPane scrollPane = new JScrollPane(contentPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		contentPane1.add(scrollPane);
		setContentPane(scrollPane);  
	}
}
