package br.edu.univas.tp4.petshop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.univas.tp4.petshop.controller.SalvarSairButtonListener;

public class ButtonPanelCadastro extends JPanel{

	private static final long serialVersionUID = 4349390655740753228L;
	
	private JButton salvarButton;
	private JButton cancelButton;
	
	private ArrayList<SalvarSairButtonListener> listeners = new ArrayList<>();

	public ButtonPanelCadastro(){
		initialize();
	}
	
	private void initialize(){
		add(getSalvarButton());
		add(getCancelButoon());
	}

	private JButton getSalvarButton() {
		if (salvarButton == null){
			salvarButton = new JButton();
			salvarButton.setText("Salvar");
			salvarButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					salvarClicked();
				}
			});
		}	
		return salvarButton;
	}

	private JButton getCancelButoon() {
		if(cancelButton == null){
			cancelButton = new JButton();
			cancelButton.setText("Cancelar");
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cancelClicked();
				}
			});
				
		}
		return cancelButton;
	}
	
	public void addButtonsListener(SalvarSairButtonListener listener){
		listeners.add(listener);
	}
	
	private void salvarClicked(){
		for(SalvarSairButtonListener listener : listeners){
			listener.salvarPerformed();
		}
	}
	
	private void cancelClicked(){
		for(SalvarSairButtonListener listener : listeners){
			listener.CancelPerformed();
		}
	}
	
	
}