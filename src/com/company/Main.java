package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

class RFIDReaderApp {

        public static void main(String[] args) {
            SwingUtilities.invokeLater(RFIDReaderApp::new);
        }

        public RFIDReaderApp() {
            // Main Frame
            JFrame frame = new JFrame("RFID Reader");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            // Reader Status Panel
            JPanel statusPanel = new JPanel(new GridLayout(1, 2));
            JLabel reader1Status = new JLabel("Reader 1: Active", SwingConstants.CENTER);
            JLabel reader2Status = new JLabel("Reader 2: Active", SwingConstants.CENTER);
            statusPanel.add(reader1Status);
            statusPanel.add(reader2Status);
            frame.add(statusPanel, BorderLayout.NORTH);

            // Tag Display Panel
            JPanel tagPanel = new JPanel(new GridLayout(1, 2));
            JTable table1 = createTagTable();
            JTable table2 = createTagTable();
            tagPanel.add(new JScrollPane(table1));
            tagPanel.add(new JScrollPane(table2));
            frame.add(tagPanel, BorderLayout.CENTER);

            // Control Panel with Buttons and Sliders
            JPanel controlPanel = new JPanel();
            JButton startButton = new JButton("Start Reading");
            JButton stopButton = new JButton("Stop Reading");
            JButton clearButton = new JButton("Clear Output");
            controlPanel.add(startButton);
            controlPanel.add(stopButton);
            controlPanel.add(clearButton);

            // Power and Sensitivity Sliders
            JSlider transmitPowerSlider = new JSlider(-30, 0, -15);
            JSlider receiveSensitivitySlider = new JSlider(-120, -60, -80);
            controlPanel.add(new JLabel("Transmit Power"));
            controlPanel.add(transmitPowerSlider);
            controlPanel.add(new JLabel("Receive Sensitivity"));
            controlPanel.add(receiveSensitivitySlider);

            // Filter Checkbox
            JCheckBox filterCheckBox = new JCheckBox("Filter EPCs with more than 9 characters");
            controlPanel.add(filterCheckBox);

            frame.add(controlPanel, BorderLayout.SOUTH);

            // Show the GUI
            frame.setVisible(true);

            // Action Listeners for Buttons
            startButton.addActionListener(e -> startReading(table1, table2));
            stopButton.addActionListener(e -> stopReading());
            clearButton.addActionListener(e -> clearOutput(table1, table2));
        }

        private JTable createTagTable() {
            String[] columns = {"Tag", "Timestamp"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            return new JTable(model);
        }

        private void startReading(JTable table1, JTable table2) {
            // Logic to start reading and updating tables
            JOptionPane.showMessageDialog(null, "Start reading tags...");
            // Example: Add tag to table1
            DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
            model1.addRow(new Object[]{"0102", "2024-10-21 22:24:11"});
            // Add to table2 similarly if required
        }

        private void stopReading() {
            JOptionPane.showMessageDialog(null, "Stop reading tags...");
        }

        private void clearOutput(JTable table1, JTable table2) {
            ((DefaultTableModel) table1.getModel()).setRowCount(0);
            ((DefaultTableModel) table2.getModel()).setRowCount(0);
        }
    }
