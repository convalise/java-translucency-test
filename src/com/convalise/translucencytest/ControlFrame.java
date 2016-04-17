
package com.convalise.translucencytest;

import com.convalise.lib.GradientPanel;
import com.convalise.lib.ImagePanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ControlFrame extends JFrame {

	private JFrame splashFrame;
	private ImagePanel imagePanel;
	private JLabel previewLabel;

	private final Dimension screenSize;
	private final boolean isPerPixelTranslucencySupported;

	private boolean initialized = false;

	public ControlFrame() {

		this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		GraphicsEnvironment GraphicsEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice GraphicsDev = GraphicsEnv.getDefaultScreenDevice();

		this.isPerPixelTranslucencySupported = GraphicsDev.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT);

		super.setTitle("Translucency Test");
		super.setResizable(false);

		initComponents();
		initComponentsCustomization();

		super.setLocation(100, Math.round((screenSize.height - super.getSize().height) / 2f));

	}
	
	private void initComponentsCustomization() {

		S_StartR.setValue(250);
		S_StartG.setValue(230);
		S_StartB.setValue(200);
		S_StartA.setValue(50);

		S_EndR.setValue(250);
		S_EndG.setValue(230);
		S_EndB.setValue(200);
		S_EndA.setValue(250);

		if(!isPerPixelTranslucencySupported) {
			S_StartA.setValue(255);
			S_StartA.setEnabled(false);
			TF_StartA.setEnabled(false);
			S_EndA.setValue(255);
			S_EndA.setEnabled(false);
			TF_EndA.setEnabled(false);
		}

		splashFrame = new JFrame();
		splashFrame.setSize(600, 360);
		splashFrame.setResizable(false);
		splashFrame.setUndecorated(true);
		splashFrame.setType(Type.UTILITY);
		splashFrame.setLocation(Math.round((screenSize.width - splashFrame.getSize().width) / 2f), Math.round((screenSize.height - splashFrame.getSize().height) / 2f));

		if(isPerPixelTranslucencySupported) {
			splashFrame.setBackground(new Color(0, 0, 0, 0));
		}
		
		imagePanel = new ImagePanel();
		imagePanel.setImageFilePath("splash.png");
		imagePanel.setGradientTranslucent(isPerPixelTranslucencySupported);
		
		previewLabel = new JLabel("preview");
		imagePanel.add(previewLabel);
		
		splashFrame.setContentPane(imagePanel);
		splashFrame.setVisible(true);
		
		initialized = true;

		updateGradient();

	}

	private void updateGradient() {

		if(!initialized) {
			return;
		}

		Color startColor = new Color(S_StartR.getValue(), S_StartG.getValue(), S_StartB.getValue(), S_StartA.getValue());
		Color endColor = new Color(S_EndR.getValue(), S_EndG.getValue(), S_EndB.getValue(), S_EndA.getValue());

		GradientPanel.GradientDirection direction = GradientPanel.GradientDirection.VERTICAL;
		
		switch(CB_Direction.getSelectedIndex()) {
			case 0: direction = GradientPanel.GradientDirection.HORIZONTAL;		break;
			case 1: direction = GradientPanel.GradientDirection.VERTICAL;		break;
			case 2: direction = GradientPanel.GradientDirection.DIAGONAL;		break;
			case 3: direction = GradientPanel.GradientDirection.ANTIDIAGONAL;	break;
		}

		imagePanel.setGradientColors(startColor, endColor);
		imagePanel.setGradientDirection(direction);
		imagePanel.setGradientBorderVisible(CB_PaintBorder.isSelected());
		imagePanel.setGradientReverse(CB_ReverseColors.isSelected());
		imagePanel.setImageVisible(CB_DrawImage.isSelected());

		previewLabel.setVisible(CB_PaintBorder.isSelected());

		splashFrame.repaint();

	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        P_StartColor = new javax.swing.JPanel();
        L_StartR = new javax.swing.JLabel();
        L_StartG = new javax.swing.JLabel();
        L_StartB = new javax.swing.JLabel();
        L_StartA = new javax.swing.JLabel();
        S_StartR = new javax.swing.JSlider();
        S_StartG = new javax.swing.JSlider();
        S_StartB = new javax.swing.JSlider();
        S_StartA = new javax.swing.JSlider();
        TF_StartR = new javax.swing.JTextField();
        TF_StartG = new javax.swing.JTextField();
        TF_StartB = new javax.swing.JTextField();
        TF_StartA = new javax.swing.JTextField();
        P_StartColor1 = new javax.swing.JPanel();
        L_EndR = new javax.swing.JLabel();
        L_EndG = new javax.swing.JLabel();
        L_EndB = new javax.swing.JLabel();
        L_EndA = new javax.swing.JLabel();
        S_EndR = new javax.swing.JSlider();
        S_EndG = new javax.swing.JSlider();
        S_EndB = new javax.swing.JSlider();
        S_EndA = new javax.swing.JSlider();
        TF_EndR = new javax.swing.JTextField();
        TF_EndG = new javax.swing.JTextField();
        TF_EndB = new javax.swing.JTextField();
        TF_EndA = new javax.swing.JTextField();
        CB_Direction = new javax.swing.JComboBox();
        CB_ReverseColors = new javax.swing.JCheckBox();
        CB_PaintBorder = new javax.swing.JCheckBox();
        CB_DrawImage = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        P_StartColor.setBorder(javax.swing.BorderFactory.createTitledBorder("START COLOR"));

        L_StartR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        L_StartR.setText("R:");

        L_StartG.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        L_StartG.setText("G:");

        L_StartB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        L_StartB.setText("B:");

        L_StartA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        L_StartA.setText("A:");

        S_StartR.setMaximum(255);
        S_StartR.setValue(0);
        S_StartR.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                S_StartRStateChanged(evt);
            }
        });

        S_StartG.setMaximum(255);
        S_StartG.setValue(0);
        S_StartG.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                S_StartGStateChanged(evt);
            }
        });

        S_StartB.setMaximum(255);
        S_StartB.setValue(0);
        S_StartB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                S_StartBStateChanged(evt);
            }
        });

        S_StartA.setMaximum(255);
        S_StartA.setValue(0);
        S_StartA.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                S_StartAStateChanged(evt);
            }
        });

        TF_StartR.setEditable(false);

        TF_StartG.setEditable(false);

        TF_StartB.setEditable(false);

        TF_StartA.setEditable(false);

        javax.swing.GroupLayout P_StartColorLayout = new javax.swing.GroupLayout(P_StartColor);
        P_StartColor.setLayout(P_StartColorLayout);
        P_StartColorLayout.setHorizontalGroup(
            P_StartColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_StartColorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_StartColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_StartG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_StartB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_StartA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_StartR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P_StartColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(S_StartR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(S_StartB, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(S_StartG, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(S_StartA, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P_StartColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF_StartR, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_StartG, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_StartB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_StartA, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        P_StartColorLayout.setVerticalGroup(
            P_StartColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_StartColorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_StartColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(P_StartColorLayout.createSequentialGroup()
                        .addComponent(TF_StartR, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_StartG, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_StartB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_StartA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(P_StartColorLayout.createSequentialGroup()
                        .addGroup(P_StartColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, P_StartColorLayout.createSequentialGroup()
                                .addComponent(L_StartR, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(L_StartG, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, P_StartColorLayout.createSequentialGroup()
                                .addComponent(S_StartR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(S_StartG, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_StartColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(L_StartB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(S_StartB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_StartColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(S_StartA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_StartA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        P_StartColorLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {S_StartA, S_StartB, S_StartG, S_StartR});

        P_StartColor1.setBorder(javax.swing.BorderFactory.createTitledBorder("END COLOR"));

        L_EndR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        L_EndR.setText("R:");

        L_EndG.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        L_EndG.setText("G:");

        L_EndB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        L_EndB.setText("B:");

        L_EndA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        L_EndA.setText("A:");

        S_EndR.setMaximum(255);
        S_EndR.setValue(0);
        S_EndR.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                S_EndRStateChanged(evt);
            }
        });

        S_EndG.setMaximum(255);
        S_EndG.setValue(0);
        S_EndG.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                S_EndGStateChanged(evt);
            }
        });

        S_EndB.setMaximum(255);
        S_EndB.setValue(0);
        S_EndB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                S_EndBStateChanged(evt);
            }
        });

        S_EndA.setMaximum(255);
        S_EndA.setValue(0);
        S_EndA.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                S_EndAStateChanged(evt);
            }
        });

        TF_EndR.setEditable(false);

        TF_EndG.setEditable(false);

        TF_EndB.setEditable(false);

        TF_EndA.setEditable(false);

        javax.swing.GroupLayout P_StartColor1Layout = new javax.swing.GroupLayout(P_StartColor1);
        P_StartColor1.setLayout(P_StartColor1Layout);
        P_StartColor1Layout.setHorizontalGroup(
            P_StartColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_StartColor1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_StartColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_StartColor1Layout.createSequentialGroup()
                        .addComponent(L_EndR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(S_EndR, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                    .addGroup(P_StartColor1Layout.createSequentialGroup()
                        .addGroup(P_StartColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(L_EndG, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_EndB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_EndA, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_StartColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(S_EndG, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(S_EndB, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(S_EndA, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P_StartColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF_EndR, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_EndG, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_EndB, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_EndA, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        P_StartColor1Layout.setVerticalGroup(
            P_StartColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_StartColor1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_StartColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(P_StartColor1Layout.createSequentialGroup()
                        .addComponent(TF_EndR, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_EndG, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_EndB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_EndA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(P_StartColor1Layout.createSequentialGroup()
                        .addGroup(P_StartColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(P_StartColor1Layout.createSequentialGroup()
                                .addComponent(L_EndR, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(L_EndG, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(P_StartColor1Layout.createSequentialGroup()
                                .addComponent(S_EndR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(S_EndG, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_StartColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(L_EndB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(S_EndB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_StartColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(S_EndA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_EndA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        P_StartColor1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {S_EndA, S_EndB, S_EndG, S_EndR});

        CB_Direction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Horizontal", "Vertical", "Diagonal", "Anti-Diagonal" }));
        CB_Direction.setSelectedIndex(1);
        CB_Direction.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CB_Direction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_DirectionActionPerformed(evt);
            }
        });

        CB_ReverseColors.setText("Reverse colors");
        CB_ReverseColors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ReverseColorsActionPerformed(evt);
            }
        });

        CB_PaintBorder.setSelected(true);
        CB_PaintBorder.setText("Paint border");
        CB_PaintBorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_PaintBorderActionPerformed(evt);
            }
        });

        CB_DrawImage.setText("Draw splash image");
        CB_DrawImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_DrawImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CB_DrawImage)
                    .addComponent(CB_PaintBorder)
                    .addComponent(CB_ReverseColors)
                    .addComponent(P_StartColor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P_StartColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CB_Direction, 0, 245, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P_StartColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P_StartColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CB_Direction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CB_ReverseColors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CB_PaintBorder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CB_DrawImage)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void S_StartRStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_S_StartRStateChanged
		TF_StartR.setText(Integer.toString(S_StartR.getValue()));
		updateGradient();
	}//GEN-LAST:event_S_StartRStateChanged

	private void S_StartGStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_S_StartGStateChanged
		TF_StartG.setText(Integer.toString(S_StartG.getValue()));
		updateGradient();
	}//GEN-LAST:event_S_StartGStateChanged

	private void S_StartBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_S_StartBStateChanged
		TF_StartB.setText(Integer.toString(S_StartB.getValue()));
		updateGradient();
	}//GEN-LAST:event_S_StartBStateChanged

	private void S_StartAStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_S_StartAStateChanged
		TF_StartA.setText(Integer.toString(S_StartA.getValue()));
		updateGradient();
	}//GEN-LAST:event_S_StartAStateChanged

	private void S_EndRStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_S_EndRStateChanged
		TF_EndR.setText(Integer.toString(S_EndR.getValue()));
		updateGradient();
	}//GEN-LAST:event_S_EndRStateChanged

	private void S_EndGStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_S_EndGStateChanged
		TF_EndG.setText(Integer.toString(S_EndG.getValue()));
		updateGradient();
	}//GEN-LAST:event_S_EndGStateChanged

	private void S_EndBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_S_EndBStateChanged
		TF_EndB.setText(Integer.toString(S_EndB.getValue()));
		updateGradient();
	}//GEN-LAST:event_S_EndBStateChanged

	private void S_EndAStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_S_EndAStateChanged
		TF_EndA.setText(Integer.toString(S_EndA.getValue()));
		updateGradient();
	}//GEN-LAST:event_S_EndAStateChanged

	private void CB_DirectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_DirectionActionPerformed
		updateGradient();
	}//GEN-LAST:event_CB_DirectionActionPerformed

	private void CB_ReverseColorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ReverseColorsActionPerformed
		updateGradient();
	}//GEN-LAST:event_CB_ReverseColorsActionPerformed

	private void CB_PaintBorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_PaintBorderActionPerformed
		updateGradient();
	}//GEN-LAST:event_CB_PaintBorderActionPerformed

	private void CB_DrawImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_DrawImageActionPerformed
		updateGradient();
	}//GEN-LAST:event_CB_DrawImageActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CB_Direction;
    private javax.swing.JCheckBox CB_DrawImage;
    private javax.swing.JCheckBox CB_PaintBorder;
    private javax.swing.JCheckBox CB_ReverseColors;
    private javax.swing.JLabel L_EndA;
    private javax.swing.JLabel L_EndB;
    private javax.swing.JLabel L_EndG;
    private javax.swing.JLabel L_EndR;
    private javax.swing.JLabel L_StartA;
    private javax.swing.JLabel L_StartB;
    private javax.swing.JLabel L_StartG;
    private javax.swing.JLabel L_StartR;
    private javax.swing.JPanel P_StartColor;
    private javax.swing.JPanel P_StartColor1;
    private javax.swing.JSlider S_EndA;
    private javax.swing.JSlider S_EndB;
    private javax.swing.JSlider S_EndG;
    private javax.swing.JSlider S_EndR;
    private javax.swing.JSlider S_StartA;
    private javax.swing.JSlider S_StartB;
    private javax.swing.JSlider S_StartG;
    private javax.swing.JSlider S_StartR;
    private javax.swing.JTextField TF_EndA;
    private javax.swing.JTextField TF_EndB;
    private javax.swing.JTextField TF_EndG;
    private javax.swing.JTextField TF_EndR;
    private javax.swing.JTextField TF_StartA;
    private javax.swing.JTextField TF_StartB;
    private javax.swing.JTextField TF_StartG;
    private javax.swing.JTextField TF_StartR;
    // End of variables declaration//GEN-END:variables

}
