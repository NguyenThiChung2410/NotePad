/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class JNotePad extends JFrame {

    private JMenuBar mBar;
    private JMenu mFile, mEdit, mFomat, mView, mZoom, mHelp;
    private JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemPageSetup, itemPrint, itemExit;
    private JMenuItem itemUndo, itemCut, itemCopy, itemPast, itemDelete, itemSearch, itemFind, itemFindNext, itemFindPrevious, itemReplace, itemGoTo, itemSelectAll, itemTimeDate;
    private JMenuItem itemFont, itemZoomIn, itemZoomOut, itemRestore, itemViewHelp, itemSendFeedback, itemaboutNotepad;
    private JCheckBoxMenuItem itemWrap, itemStatusBar;
    private JTextArea txtEditor;
    private JToolBar toolbar;
    private JButton btNew,btOpen,btSave;

    int size = 20;

    public JNotePad(String title) {
        super(title);
        createMenu();
        createGUI();
        createToolBar();
        processEvent();
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    private void createMenu() {
        mBar = new JMenuBar();
        mBar.add(mFile = new JMenu("File"));
        mBar.add(mEdit = new JMenu("Edit"));
        mBar.add(mFomat = new JMenu("Fomat"));
        mBar.add(mView = new JMenu("View"));
        mBar.add(mHelp = new JMenu("Help"));

        mFile.add(itemNew = new JMenuItem("New"));
        mFile.add(itemOpen = new JMenuItem("Open..."));
        mFile.add(itemSave = new JMenuItem("Save"));
        mFile.add(itemSaveAs = new JMenuItem("Save As..."));
        mFile.addSeparator();
        mFile.add(itemPageSetup = new JMenuItem("Page Setup..."));
        mFile.add(itemPrint = new JMenuItem("Print..."));
        mFile.addSeparator();
        mFile.add(itemExit = new JMenuItem("Exit"));

        mEdit.add(itemUndo = new JMenuItem("Undo"));
        mEdit.addSeparator();
        mEdit.add(itemCut = new JMenuItem("Cut"));
        mEdit.add(itemCopy = new JMenuItem("Copy"));
        mEdit.add(itemPast = new JMenuItem("Paste"));
        mEdit.add(itemDelete = new JMenuItem("Delete"));
        mEdit.addSeparator();
        mEdit.add(itemSearch = new JMenuItem("Search with Bing..."));
        mEdit.add(itemFind = new JMenuItem("Find"));
        mEdit.add(itemFindNext = new JMenuItem("Find Next"));
        mEdit.add(itemFindPrevious = new JMenuItem("Find Previous"));
        mEdit.add(itemReplace = new JMenuItem("Replace..."));
        mEdit.add(itemGoTo = new JMenuItem("Go To..."));
        mEdit.addSeparator();
        mEdit.add(itemSelectAll = new JMenuItem("Select All"));
        mEdit.add(itemTimeDate = new JMenuItem("Time/Date"));

        mFomat.add(itemWrap = new JCheckBoxMenuItem("Word Wrap", true));
        mFomat.add(itemFont = new JMenuItem("Font..."));

        mView.add(mZoom = new JMenu("Zoom"));
        mView.add(itemStatusBar = new JCheckBoxMenuItem("Status Bar", true));
        mZoom.add(itemZoomIn = new JMenuItem("Zoom In"));
        mZoom.add(itemZoomOut = new JMenuItem("Zoom Out"));
        mZoom.add(itemRestore = new JMenuItem("Restore Default Zoom"));

        mHelp.add(itemViewHelp = new JMenuItem("View Help"));
        mHelp.add(itemSendFeedback = new JMenuItem("Send Feedback"));
        mHelp.add(itemaboutNotepad = new JMenuItem("About Notepad"));

        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));

        itemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        itemPast.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        itemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        itemSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
        itemFindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        itemFindPrevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, KeyEvent.SHIFT_DOWN_MASK));
        itemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
        itemGoTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));
        itemSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        itemTimeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));

        itemZoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK));
        itemZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK));
        itemRestore.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.CTRL_DOWN_MASK));

        setJMenuBar(mBar);

    }

    public static void main(String[] args) {
        JNotePad notepad = new JNotePad("Demo NotePad");
        notepad.setVisible(true);
    }

    private void createGUI() {
        txtEditor = new JTextArea();
        JScrollPane scr = new JScrollPane(txtEditor);
        add(scr);
        txtEditor.setFont(new Font("Arial", Font.PLAIN, size));
    }

    private void processEvent() {
        itemZoomIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size += 4;
                txtEditor.setFont(new Font("Arial", Font.PLAIN, size));
            }
        });
        itemZoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size -= 4;
                txtEditor.setFont(new Font("Arial", Font.PLAIN, size));
            }
        });
        itemRestore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtEditor.setFont(new Font("Arial", Font.PLAIN, 20));
            }
        });
        itemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        itemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }

        });
        itemSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAsFile();
            }

        });
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exit();
            }

        });

        itemCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Copy();
            }

        });
        itemPast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paste();
            }

        });
        itemWrap.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (itemWrap.isSelected()) {
                    txtEditor.setLineWrap(true);
                } else {
                    txtEditor.setLineWrap(false);
                }
            }
        });
        btOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        btSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
    }

    private void openFile() {
        JFileChooser dlgFile = new JFileChooser();
        if (dlgFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fis = new FileInputStream(dlgFile.getSelectedFile());
                byte[] b = new byte[fis.available()];
                fis.read(b);
                txtEditor.setText(new String(b));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, " Lỗi đọc File");
            }
        }
    }

    private void saveFile() {
        JFileChooser dlgFile = new JFileChooser();
        if (dlgFile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileOutputStream fos = new FileOutputStream(dlgFile.getSelectedFile());
                fos.write(txtEditor.getText().getBytes());
                fos.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi ghi file: " + ex.getMessage());
            }
        }
    }

    private void saveAsFile() {
        JFileChooser dlgFile = new JFileChooser();
        if (dlgFile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileOutputStream fos = new FileOutputStream(dlgFile.getSelectedFile());
                fos.write(txtEditor.getText().getBytes());
                fos.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi ghi file: " + ex.getMessage());
            }
        }
    }

    private void Exit() {
        if (JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thoát chứ?") == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void Copy() {
        String selectedText = txtEditor.getSelectedText();
        if (selectedText != null && !selectedText.isEmpty()) {
            StringSelection stringSelection = new StringSelection(selectedText);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } else {
            JOptionPane.showMessageDialog(txtEditor, "Không có nội dung để sao chép!!!");
        }
    }

    private void Paste() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            String pastedText = (String) clipboard.getData(DataFlavor.stringFlavor);
            txtEditor.insert(pastedText, txtEditor.getCaretPosition());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(txtEditor, "Lỗi dán nội dung: " + ex.getMessage());
        }
    }

    private void createToolBar() {
        toolbar=new JToolBar();
        toolbar.add(btNew=new JButton("New"));
        toolbar.add(btOpen=new JButton("Open"));
        toolbar.add(btSave=new JButton("Save"));
        
        btNew.setIcon(new ImageIcon(this.getClass().getResource("/images/new.png")));
        btOpen.setIcon(new ImageIcon(this.getClass().getResource("/images/open.png")));
        btSave.setIcon(new ImageIcon(this.getClass().getResource("/images/save.png")));
        
        add(toolbar, BorderLayout.NORTH);
    }
}
