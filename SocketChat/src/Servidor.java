import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Servidor extends JFrame implements Runnable {
	
	JTextArea textomensagens;
	
	
	
	public Servidor(){
		textomensagens = new JTextArea();
		textomensagens.setBounds(10,10,400,400);
		
		
		
		add(textomensagens);
		setLayout(null);
		setSize(400, 400);
		setVisible(true);
		Thread fio = new Thread(this);
		fio.start();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Servidor();

	}

	@Override
	public void run() {
		try{
			ServerSocket servidor = new ServerSocket(5000);
			Socket cliente;
			
			while(true){
			
			cliente = servidor.accept();
			DataInputStream fluxo = new DataInputStream(cliente.getInputStream());
			
			String mensagem = fluxo.readUTF();
			textomensagens.append("\n"+mensagem);
			cliente.close();
			
			if(mensagem.equalsIgnoreCase("Fim")){
				servidor.close();
				break;
			}
			}
			
			
		
		} catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		
	}

}
