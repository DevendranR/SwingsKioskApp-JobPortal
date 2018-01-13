package com.dev.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.dev.bean.Job;
import com.dev.resources.Factory;

public class HomePage extends JFrame{
	
	private static final Logger LOGGER = Logger.getLogger(HomePage.class);
	private JPanel contentPane;
	private static List<Job> jobs;
	static HomePage frame;
	
	
	public static void main(String[] args) {
		try {
			jobs = Factory.createJobService().retrieveJobs();
			
			
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame = new HomePage(null);
					frame.setVisible(true);
				} catch (Exception e) {
					LOGGER.error("\nException Occured: "+e.getMessage());
					LOGGER.error(e.getMessage(), e);
				}
			}
		});
	}
	
	public HomePage(String subJob){
		
		
		setResizable(true);
		setTitle("Job Portal...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
	    
	    JPanel contentPane1 = new JPanel(null); 
	    

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xFFFFFF));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		if(subJob!=null){
			JButton home = new JButton("Home");
			
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
		}
		JLabel jobDetailsLabel = new JLabel("Job Details");
		jobDetailsLabel.setForeground(new Color(0x000080));
		jobDetailsLabel.setBounds(10, 0, 500, 50);
		jobDetailsLabel.setFont(new Font("Verdana",Font.BOLD,24));
		contentPane.add(jobDetailsLabel);
		
		JLabel space = new JLabel("________________________________________________________________");
		space.setForeground(new Color(0x000080));
		space.setFont(new Font("Verdana",Font.PLAIN,30));
		contentPane.add(space);

		int x = 0;
		int y = 0;
		int z =0;
		List<Job> iterableJobs = null;
		if(subJob==null){
			iterableJobs = new ArrayList<>();
			for (Job job : jobs) {
				if(job.getJobLevel().equals("1")){
					iterableJobs.add(job);
				}
			}
		}
		else{
			String[] subJobArray = subJob.split(",");
			iterableJobs = new ArrayList<Job>();
			for (String string : subJobArray) {
				for (Job job : jobs) {
					if(job.getJobCode().equals(string)){
						iterableJobs.add(job);
					}
				}
			}
		}
		for (Job job : iterableJobs) {
			
			JButton jobCodeButton = new JButton(job.getJobTitle());
			jobCodeButton.setBackground(new Color(0x000080));
			jobCodeButton.setForeground(new Color(0xFFFFFF));
			jobCodeButton.setBorderPainted(false);
			jobCodeButton.setBounds(screenSize.width/4+x,screenSize.height/3+y,200,60);
			jobCodeButton.setFont(new Font("Verdana",Font.BOLD,16));
			contentPane.add(jobCodeButton);
			final String jc = job.getJobCode();
			final Job finaljob = job;
			jobCodeButton.addActionListener( new ActionListener() 
		    {
		        public void actionPerformed(ActionEvent e)
		            {
			        	try{
			        		if(finaljob.getSubJob()==null){
			        			ApplyForJob.applyFrame = new ApplyForJob(jc);
				                ApplyForJob.applyFrame.setVisible(true);
				                setVisible(false);
			        		}else{
			        			setVisible(false);
			        			HomePage.frame = new HomePage(finaljob.getSubJob());
			        			HomePage.frame.setVisible(true);
			        		}
					        		
			            }catch(Exception e1){
			            	LOGGER.error("\nException Occured: "+e1.getMessage());
							LOGGER.error(e1.getMessage(), e1);
			            }
		            
		            }
		    });
			z++;
			x = x+210;
			if(z == 4){
				y = y+100;
				x = 0;
			}
			JLabel space1 = new JLabel(" ");
			space1.setFont(new Font("Verdana",Font.PLAIN,16));
			contentPane.add(space1);
			
			
		
		}
		
		
		JScrollPane scrollPane = new JScrollPane(contentPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		contentPane1.add(scrollPane);
		setContentPane(scrollPane);  
		
				

		
		
	
	}
}
