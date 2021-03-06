package rmiclient.frames;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import rmicore.Service;
import rmicore.domain.User;

public class InsertNewsFrame extends javax.swing.JFrame {

    
    private final Service rm;
    private final User user;
    private final int MAX_LENGTH_NEWS = 180;


    public InsertNewsFrame(Service rm, User user) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.rm = rm;
        this.user = user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_nametopic = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_news = new javax.swing.JTextArea();
        bt_enviar = new javax.swing.JButton();
        bt_VoltarMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inserção de notícias");

        jLabel1.setText("Inserir notícia em um tópico:");

        jLabel2.setText("Tópico:");

        jLabel3.setText("Notícia:");

        ta_news.setColumns(20);
        ta_news.setRows(5);
        jScrollPane1.setViewportView(ta_news);

        bt_enviar.setText("Enviar");
        bt_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_enviarActionPerformed(evt);
            }
        });

        bt_VoltarMenu.setText("Voltar para o Menu Inicial");
        bt_VoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_VoltarMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tf_nametopic))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bt_enviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(bt_VoltarMenu)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_nametopic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_enviar)
                    .addComponent(bt_VoltarMenu))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_enviarActionPerformed
        try {
            if(isValidParameters(tf_nametopic.getText(), ta_news.getText())){
                if (rm.insertNewsOnTopic(user, tf_nametopic.getText(), ta_news.getText()) != null ){
                    JOptionPane.showMessageDialog(null, "Noticia publicada com sucesso!");
                    tf_nametopic.setText("");
                    ta_news.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao publicar notícia!");
                }
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao publicar notícia: " + ex.getMessage());
        }
    }//GEN-LAST:event_bt_enviarActionPerformed
    
    private boolean isValidParameters(String topic, String news){
        if (topic.isEmpty()){
            JOptionPane.showMessageDialog(null, "É obrigatório informar o tópico!");
            return false;
        }
        if (news.isEmpty()){
            JOptionPane.showMessageDialog(null, "É obrigatório informar o conteúdo da notícia!");
            return false;
        }
        if (news.length() > MAX_LENGTH_NEWS){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres da notícia deve ser 180!");
            return false;
        }
        return true;
    }
    
    private void bt_VoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_VoltarMenuActionPerformed
       this.dispose();
    }//GEN-LAST:event_bt_VoltarMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_VoltarMenu;
    private javax.swing.JButton bt_enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_news;
    private javax.swing.JTextField tf_nametopic;
    // End of variables declaration//GEN-END:variables
}
