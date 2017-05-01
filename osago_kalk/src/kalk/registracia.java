/**
 * объявление пакета
 */
package kalk;
/**
 * подключение необходимых библиотек для работы с экранными формами, событиями
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * объявление публичного класса, наследующего члены класса JFrame, для создания формы регистрация
 */


public class registracia extends JFrame{	
	
	/**
	 * объявление главного метода
	 */
	
	
	public static void main(String[] args) {	
		
		/**
		 * Метод, отвечающий за запуск фрейма
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registracia frame = new registracia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * объявление метода, в котором объявляются элементы экранной формы и ее события
	 */
	 public registracia() {
		 /**
		   * Создание главной панели и контура вокруг нее
		 */
	JPanel mainPanel = new JPanel(new BorderLayout());
	mainPanel.setBorder(BorderFactory.createTitledBorder("Регистрация"));
	/**
	 * Создание панелей для размешения: 
	 * текстовых полей
	 * кнопок
	 * меток
	 */
	JPanel TextField = new JPanel(new GridLayout(3, 2, 2, 2));
	JPanel But = new JPanel(new FlowLayout());
	/**
	 * Задание шрифта и размера надписей для кнопок, меток, переключателей
	 */
	Font font = new Font("Verdana", Font.PLAIN, 14); 
	/**
	 * Cоздание текстовых полей для ввода логина и паролей
	 */
	JTextField login = new JTextField();
	JPasswordField password = new JPasswordField();
	JPasswordField repeatPassword = new JPasswordField();
	/**
	 * Создание кнопоки 
	 */
	JButton registr = new JButton("Регистрация");
	registr.setFont(font);
	/**
	 * Создание меток
	 */
	JLabel loginl = new JLabel("Логин");
	loginl.setFont(font);
	JLabel Password = new JLabel("Пароль");
	Password.setFont(font);
	JLabel Password2 = new JLabel("Повторите пароль");
	Password2.setFont(font);
	
	/**
	 * Добавление элементов на панель для текстовых полей
	 */
	TextField.add(loginl);
	TextField.add(login);
	TextField.add(Password);
	TextField.add(password);
	TextField.add(Password2);
	TextField.add(repeatPassword);
	
	/**
	 * Добавление элементов на панель для кнопок
	 */
	But.add(registr);
	/**
	 * Добавление элементов на главную панель
	 */
	mainPanel.add(TextField, BorderLayout.NORTH);
	mainPanel.add(But, BorderLayout.SOUTH);
	/**
	 * Указание размера, расположения, названия экранной формы, добавление на нее главной панели
	 */
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Калькулятор ОСАГО");
	setContentPane(mainPanel);
	setBounds(100, 100, 310, 200);
	
	/**
	 * Событие для кнопки "Регистрации"
	 */
		registr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String fileName="login.txt";
				String p = password.getText();
				String o = repeatPassword.getText();
				String r = login.getText();
				/**
				 * Добавление логина и пароля нового пользователя в файл 
				 */
				if((login.getText().equals("") || password.getText().equals("") || repeatPassword.getText().equals("")) == false){
				if(p.equals(o)) {
					DateBase.write(fileName, r, p);
					avtorizacia();
				}
				else JOptionPane.showMessageDialog(null,"Неверно повторен пароль");
				}
				}
			/**
			 * Процедура отвечающая за переход на фрейм "Авторизация"
			 */
			private void avtorizacia() {
				avtorizacia fr1 = new avtorizacia(); 
				fr1.setVisible(true); 
				setVisible(false);
			}
		});
	}
}
