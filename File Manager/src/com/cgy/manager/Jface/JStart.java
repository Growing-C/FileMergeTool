package com.cgy.manager.Jface;

import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import swing2swt.layout.BoxLayout;

public class JStart extends ApplicationWindow {
//	private Text inputDir;
	private Text outputDir;
	private Text logText;
	Combo combo0;
	private Text text;
	private Text text_1;

	/**
	 * Create the application window,
	 */
	public JStart() {
		super(null);
		createActions();
		addCoolBar(SWT.FLAT);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(3, false));

		Label label0 = new Label(container, SWT.NONE);
		label0.setText("请选择文件操作：");

		combo0 = new Combo(container, SWT.READ_ONLY);
		combo0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("index:" + combo0.getSelectionIndex());
				switch (combo0.getSelectionIndex()) {
				case 0:// 批量删除

					break;
				case 1:// 批量重命名

					break;

				default:
					break;
				}
			}
		});
		GridData gd_combo0 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_combo0.widthHint = 100;
		combo0.setLayoutData(gd_combo0);
		combo0.add("批量删除");
		combo0.add("批量重命名");
		combo0.select(0);

		// Label inputLabel = new Label(container, SWT.NONE);
		// inputLabel.setText("源文件路径：");
		//
		// inputDir = new Text(container, SWT.BORDER);
		// GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, false, false,
		// 1, 1);
		// gd_text.widthHint = 261;
		// inputDir.setLayoutData(gd_text);
		//
		// Button btnNewButton = new Button(container, SWT.NONE);
		// btnNewButton.addSelectionListener(new SelectionAdapter() {
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// String path = openFile("请选择要导入的文件夹目录：",true);
		// if (path != null && !"".equals(path)) {
		// inputDir.setText(path);
		// logText.setText(path);
		// }
		// }
		// });
		// btnNewButton.setText(" 打开 ");

		Label outputLabel = new Label(container, SWT.NONE);
		outputLabel.setText("选择文件夹路径：");

		outputDir = new Text(container, SWT.BORDER);
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_1.widthHint = 261;
		outputDir.setLayoutData(gd_text_1);

		Button btnNewButton_1 = new Button(container, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String path = openFile("请选择要目标文件夹目录：", true);
				if (path != null && !"".equals(path)) {
					outputDir.setText(path);
				}
			}
		});
		btnNewButton_1.setText("  选择  ");

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label label = new Label(container, SWT.NONE);
		label.setText("重命名规则：");

		Combo combo = new Combo(container, SWT.READ_ONLY);
		GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_combo.widthHint = 100;
		combo.setLayoutData(gd_combo);
		combo.add("字符替换");
		combo.add("全部替换");
		combo.add("2");
		combo.add("3");
		combo.select(0);
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		composite.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 3, 1));
		
		text = new Text(composite, SWT.BORDER);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setText("New Label");
		
		text_1 = new Text(composite, SWT.BORDER);
		
		Label description = new Label(container, SWT.NONE);
		description.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		description.setText("");

		// Composite composite = new Composite(container, SWT.NONE);
		// composite.setLayout(new GridLayout(1, false));
		// composite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
		// false, 2, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		logText = new Text(container, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
		GridData logGrid = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 4);
		logGrid.heightHint = 214;
		logText.setLayoutData(logGrid);

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Button btnNewButton_2 = new Button(container, SWT.NONE);
		btnNewButton_2.setText("开始执行");
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		return container;
	}

	public String openFile(String msg, boolean multi) {
		String selectedDir;
		if (multi) {
			FileDialog dialog = new FileDialog(getShell(), SWT.MULTI);
			dialog.setText("浏览文件夹");
			dialog.setFilterPath("SystemDrive");
			selectedDir = dialog.open();
			dialog.getFilterPath();
		} else {
			DirectoryDialog dialog = new DirectoryDialog(getShell());
			dialog.setText("浏览文件夹");
			dialog.setFilterPath("SystemDrive");
			dialog.setMessage(msg);
			selectedDir = dialog.open();
		}
		return selectedDir;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the status line manager.
	 * 
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			JStart window = new JStart();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * 
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("File Manager");
		Image image = new Image(Display.getCurrent(), this.getClass().getResourceAsStream("/res/eclipse.png"));
		newShell.setImage(image);
		// newShell.redraw();

	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 500);
	}
}
