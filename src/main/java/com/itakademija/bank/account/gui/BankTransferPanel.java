package com.itakademija.bank.account.gui;

import com.itakademija.bank.account.persistence.BankAccount;
import com.itakademija.bank.account.persistence.BankAccountDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class BankTransferPanel extends JPanel {

    private final BankAccountDao bankAccountDao = new BankAccountDao();
    private final JComboBox<BankAccount> fromAccountComboBox;
    private final JComboBox<BankAccount> toAccountComboBox;
    private final JTextField amountTextField;
    private final JButton transferButton;

    public BankTransferPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel fromLabel = new JLabel("From Bank Account:");
        JLabel amountLabel = new JLabel("Amount:");
        JLabel toLabel = new JLabel("To Bank Account:");

        Vector<BankAccount> bankAccounts = new Vector<>(bankAccountDao.getAll());
        this.fromAccountComboBox = new JComboBox<>(bankAccounts);
        this.toAccountComboBox = new JComboBox<>(bankAccounts);
        this.amountTextField = new JTextField(10);
        this.amountTextField.addKeyListener(new NumberKeyAdapter());

        this.transferButton = new JButton("TRANSFER");
        this.transferButton.addActionListener(this::onTransferButtonClicked);

        // Dodavanje komponenti na panel
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(fromLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        add(fromAccountComboBox, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(amountLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        add(amountTextField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(toLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        add(toAccountComboBox, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        add(transferButton, gridBagConstraints);
    }

    private void onTransferButtonClicked(ActionEvent event) {
        int fromSelectedIndex = fromAccountComboBox.getSelectedIndex();
        BankAccount fromBankAccount = fromAccountComboBox.getItemAt(fromSelectedIndex);

        int toSelectedIndex = toAccountComboBox.getSelectedIndex();
        BankAccount toBankAccount = toAccountComboBox.getItemAt(toSelectedIndex);

        Double amount = Double.parseDouble(amountTextField.getText());

        boolean success = bankAccountDao.transfer(fromBankAccount, toBankAccount, amount);

        String message = success ? "Uspješan transfer" : "Neuspješan transfer";
        JOptionPane.showMessageDialog(null, message);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bank Transfer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new BankTransferPanel());
            frame.pack();
            frame.setVisible(true);
        });
    }
}