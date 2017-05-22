import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Cliente extends JFrame implements ActionListener{
	
	JTextField textomensagem;
	JButton enviar;
	
	
	public Cliente(){
		textomensagem = new JTextField();
		textomensagem.setBounds(10, 10, 200, 20);
		add(textomensagem);
		
		enviar = new JButton();
		enviar.setText("Enviar");
		enviar.setBounds(10, 40, 150, 20);
		enviar.addActionListener((ActionListener) this);
		add(enviar);
		
		setLayout(null);
		setSize(400,400);
		setVisible(true);
		
	}

	public static void main(String[] args) {
	
		new Cliente();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == enviar){
			try{
				Socket cliente = new Socket("127.0.0.1", 5000);
				DataOutputStream fluxo = new DataOutputStream(cliente.getOutputStream());
				
				fluxo.writeUTF(textomensagem.getText());
				cliente.close();
				
				
				
			} catch(Exception ex){
				System.out.println("Erro no cliente" + ex.getMessage());
				
			}
			
		}
	}

}
