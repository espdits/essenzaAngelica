/*
 * Finestra di errore inserimento dati sbagliati
 */
package angelicaproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gianni
 */
public class errInsPar extends JFrame {
    
    
 private JPanel contentPane;
    int newSize = 14;
    Font newFont = new Font("Georgia", Font.ITALIC, newSize);
    
    //Colore sfondo finestra errore
    Color sfondo = new Color(155,153,0);

    public errInsPar(final JFrame winErrore) {
        getContentPane().setEnabled(false);
        setTitle("Attenzione!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(30, 30, 350, 220);
        getContentPane().setLayout(null);
        JButton button = new JButton("Esci");
        button.setFont(newFont);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                winErrore.dispose();
                errInsPar.this.dispose();

            }
        });

        button.setBounds(122, 100, 90, 22);
        getContentPane().add(button);

        JEditorPane finestraTesto = new JEditorPane();
        finestraTesto.setEditable(false);
        finestraTesto.setText("          Hai inserito dei dati \n                  SBAGLIATI !!!");
        finestraTesto.setFont(newFont);
        finestraTesto.setBounds(40, 30, 260, 40);
        getContentPane().add(finestraTesto);
        
        //All'interno della finestra è presente il contentPane
        contentPane = new JPanel();
        getContentPane().setBackground(sfondo);

    }
}
    
    
