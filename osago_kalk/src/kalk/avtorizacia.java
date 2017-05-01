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
 * объявление публичного класса, наследующего члены класса JFrame, для создания формы аутентификации
 */

public class avtorizacia extends JFrame{
	/**
	 * объявление метода, в котором объявляются элементы экранной формы и ее события
	 */
	public  avtorizacia(){
	/**
	 * Создание главной панели и контура вокруг нее
	 */
	JPanel mainPanel = new JPanel(new BorderLayout());
	mainPanel.setBorder(BorderFactory.createTitledBorder("Авторизация"));
	/**
	 * Создание панелей для размешения: 
	 * текстовых полей
	 * переключателей
	 * кнопок и меток
	 * кнопок
	 * меток
	 */
	JPanel TextField = new JPanel(new GridLayout(2, 2, 2, 2));
	JPanel RadioBut = new JPanel(new GridLayout(2, 1));
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
	
	/**
	 * создание переключателей для определения, кто входит в ситсему
	 */
	JRadioButton klient = new JRadioButton("Клиент", true);
	JRadioButton agent = new JRadioButton("Страховой агент", false);
	klient.setFont(font);
	agent.setFont(font);
	
	/**
	 * Создание кнопок 
	 */
	JButton in = new JButton("Вход");
	in.setFont(font);
	JButton registr = new JButton("Регистрация");
	registr.setFont(font);
	/**
	 * Создание меток
	 */
	JLabel loginl = new JLabel("Логин");
	loginl.setFont(font);
	JLabel Password = new JLabel("Пароль");
	Password.setFont(font);

		/**
		 * Добавление элементов на панель для текстовых полей
		 */
		TextField.add(loginl);
		TextField.add(login);
		TextField.add(Password);
		TextField.add(password);
				/**
		 * Добавление элементов на панель для переключателей
		 */
		RadioBut.add(klient);
		RadioBut.add(agent);
		/**
		 * Добавление элементов на панель для кнопок
		 */
		But.add(in);
		But.add(registr);

		/**
		 * Добавление элементов на главную панель
		 */
		mainPanel.add(TextField, BorderLayout.NORTH);
		mainPanel.add(RadioBut, BorderLayout.CENTER);
		mainPanel.add(But, BorderLayout.SOUTH);
		
		/**
		 * Указание размера, расположения, названия экранной формы, добавление на нее главной панели
		 */
		setTitle("Калькулятор ОСАГО");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		setBounds(100, 100, 300, 220);
		
		/**
		 * Событие при выборе RadioButton "Страховой агент"
		 */
		agent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				klient.setSelected(false);
			}
		});
		
		/**
		 * Событие при выборе RadioButton "Клиент"
		 */
		klient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agent.setSelected(false);
			}
		});
		/**
		 * Событие для кнопки регистрация
		 */
		registr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/**
				 * переход в окно регистрации
				 */
				registracia();
			}
			/**
			 * Процедура отвечающая за переход на фрейм "Регистрация"
			 */
			private void registracia() {
				registracia fr1 = new registracia(); 
				fr1.setVisible(true); 
				setVisible(false);
			}
		});
		/**
		 * Событие для кнопки "Вход"
		 */
		in.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/**
				 * проверка корректности введеных данных
				 */
				if (agent.isEnabled() == true && login.getText().equals("rushan") && password.getText().equals("09100806")) agent();
				else				
				if (klient.isEnabled() == true)
					 {
						String fileName="login.txt";
						boolean hm = false;
						hm = DateBase.read(fileName, login, password);
						if (hm == true) klent();
						else JOptionPane.showMessageDialog(null,"Неверно введен логин или пароль");
					 }
				else JOptionPane.showMessageDialog(null,"Неверно введен логин или пароль");
			}
			
			/**
			 * Процедура отвечающая за переход на фрейм "клиент"
			 */
			private void klent() {
				klient fr1 = new klient(); 
				fr1.setVisible(true); 
				setVisible(false);
			}
			/**
			 * Процедура отвечающая за переход на фрейм "агент"
			 */
			private void agent() {
				agent fr1 = new agent(); 
				fr1.setVisible(true); 
				setVisible(false);
			}
		});
	}
	
	/**
	 * объявление главного метода
	 */
public static void main (String [] args) {
	/**
	 * Метод, отвечающий за запуск фрейма. invokeLater - приоритет; данное событие будет запущено позже других.
	 */
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				avtorizacia frame = new avtorizacia();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
 }
}
