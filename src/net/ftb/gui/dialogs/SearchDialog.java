package net.ftb.gui.dialogs;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.ftb.gui.LaunchFrame;
import net.ftb.gui.panes.MapsPane;
import net.ftb.gui.panes.ModpacksPane;
import net.ftb.gui.panes.TexturepackPane;

public class SearchDialog extends JDialog {
	public static String lastPackSearch = "", lastMapSearch = "", lastTextureSearch = "";
	public JTextField searchBar = new JTextField();

	public SearchDialog(final ModpacksPane instance) {
		super(LaunchFrame.getInstance(), true);
		setUpGui();
		searchBar.setText((lastPackSearch == null) ? "" : lastPackSearch);
		searchBar.getDocument().addDocumentListener(new DocumentListener() {
			@Override public void removeUpdate(DocumentEvent arg0) {
				lastPackSearch = searchBar.getText();
				instance.sortPacks();
			}
			@Override public void insertUpdate(DocumentEvent arg0) {
				lastPackSearch = searchBar.getText();
				instance.sortPacks();
			}
			@Override public void changedUpdate(DocumentEvent arg0) { }
		});
		searchBar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				lastPackSearch = searchBar.getText();
				instance.sortPacks();
				setVisible(false);
			}
		});
	}

	public SearchDialog(final MapsPane instance) {
		super(LaunchFrame.getInstance(), true);
		setUpGui();
		searchBar.setText((lastMapSearch == null) ? "" : lastMapSearch);
		searchBar.getDocument().addDocumentListener(new DocumentListener() {
			@Override public void removeUpdate(DocumentEvent arg0) {
				lastMapSearch = searchBar.getText();
				instance.sortMaps();
			}
			@Override public void insertUpdate(DocumentEvent arg0) {
				lastMapSearch = searchBar.getText();
				instance.sortMaps();
			}
			@Override public void changedUpdate(DocumentEvent arg0) { }
		});
		searchBar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				lastPackSearch = searchBar.getText();
				instance.sortMaps();
				setVisible(false);
			}
		});
	}

	public SearchDialog(final TexturepackPane instance) {
		super(LaunchFrame.getInstance(), true);
		setUpGui();
		searchBar.setText((lastTextureSearch == null) ? "" : lastTextureSearch);
		searchBar.getDocument().addDocumentListener(new DocumentListener() {
			@Override public void removeUpdate(DocumentEvent arg0) {
				lastTextureSearch = searchBar.getText();
				instance.sortTexturePacks();
			}
			@Override public void insertUpdate(DocumentEvent arg0) {
				lastTextureSearch = searchBar.getText();
				instance.sortTexturePacks();
			}
			@Override public void changedUpdate(DocumentEvent arg0) { }
		});
		searchBar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				lastPackSearch = searchBar.getText();
				instance.sortTexturePacks();
				setVisible(false);
			}
		});
	}

	private void setUpGui() {
		setTitle("Text Search Filter");
		setBounds(300, 300, 220, 90);
		setResizable(false);
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/image/logo_ftb.png")));
		searchBar.setBounds(10, 10, 200, 30);
		getContentPane().add(searchBar);
	}
}
