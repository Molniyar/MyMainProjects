import javax.swing.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Coder {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Coder");
        frame.setBounds(50,50,800, 600);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        textField.setBounds(10,10,760,30);

        JTextField res = new JTextField();
        res.setBounds(10,60,760,30);

        JButton button = new JButton("Code 1");
        button.setBounds(20,100,200,100);

        button.addActionListener(e -> {
            String s = textField.getText();

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                switch (s.toLowerCase().charAt(i)){//☉  ᛚ  ⇂  ○   ⊡  ⍋   ↽   ᛋ   Ⰽ  ⊗  ᛝ
                    case 'а' -> result.append("⍋");
                    case 'б' -> result.append("」");
                    case 'в' -> result.append("Ⰽ");
                    case 'г' -> result.append("ⴴ");
                    case 'д' -> result.append("ᛝ");
                    case 'е' -> result.append("ᖷⲻ");
                    case 'ё' -> result.append("ᖷⲻ");
                    case 'ж' -> result.append("◬");
                    case 'з' -> result.append("▽");
                    case 'и' -> {
                        if (s.charAt(i+1) == 'й'){
                            result.append('⊞');
                            i++;
                        }
                        else result.append("⊡");
                    }
                    case 'й' -> result.append("☒");
                    case 'к' -> result.append("Ǝ");
                    case 'л' -> result.append("ᛋ");
                    case 'м' -> result.append("ᒣ⟨");
                    case 'н' -> result.append("Ⱎ");
                    case 'о' -> result.append("⇂");
                    case 'п' -> result.append("⟐");
                    case 'р' -> result.append("ᛚ");
                    case 'с' -> result.append("↽");
                    case 'т' -> result.append("ⴳ");
                    case 'у' -> result.append("○");
                    case 'ф' -> result.append("У");
                    case 'х' -> result.append("_");
                    case 'ц' -> result.append("ʁ");
                    case 'ч' -> result.append("ʁ");
                    case 'ш' -> result.append("◁▷");
                    case 'щ' -> result.append("◁▷");//◁▷
                    case 'ъ' -> result.append("⌉");
                    case 'ы' -> result.append("⊡");
                    case 'ь' -> result.append("|");
                    case 'э' -> result.append("⊗");
                    case 'ю' -> result.append("⦺");
                    case 'я' -> {
                        if (i > 0){
                            char c = s.charAt(i-1);
                            if (c!='б'&&c!='в'&&c!='г'&&c!='д'&&c!='ж'&&c!='з'&&c!='й'&&c!='к'&&c!='л'&&c!='м'&&c!='н'&&c!='п'&&c!='р'&&c!='с'&&c!='т'&&c!='ф'&&c!='х'&&c!='ц'&&c!='ч'&&c!='ш'&&c!='щ'&&c!='ь'){
                                result.append("☒");
                            }
                        }
                        if (i == 0){
                            result.append("☒");//☒⍋
                        }
                        result.append("⍋");
                    }
                    default -> result.append(s.charAt(i));
                }
            }

            res.setText(result.toString());
        });

        JButton button2 = new JButton("Code 2");
        button2.setBounds(240,100,200,100);
        button2.addActionListener(e -> {
            String s = textField.getText().toLowerCase();

            StringBuilder result = new StringBuilder();
            String[] keep = {"⊙","ᛧ」","ᚬ","ᖶ","∑","ⵅ⊖","ⵅ◇","ᛞ","ᛝ","Ⱎ","ⵅ","Ł","⇂","⍋","⯘","◇","⊟","ᖴ","⊏","⟂","▽","Ⰽ","⋈","⟓","⋃","⊿","ᚻ","♇","ⵅⰞ","⊐","⊖","ⵅ▽","ⵅ⊙"};
            for (int i = 0; i < s.length(); i++){
                char char_ = s.charAt(i);
                if (char_ >= 'а' && char_ <= 'я'){
                    result.append(keep[char_-'а']);
                }
                else if (char_ == '!'){
                    result.append('⇃');
                }
                else if (char_ == '?'){
                    result.append('↿');
                }
                else result.append(char_);
            }
            res.setText(result.toString());
        });

        AtomicBoolean showImages = new AtomicBoolean(false);
        JButton button3 = new JButton("Code 3");
        button3.setBounds(460,100,200,100);
        button3.addActionListener(e -> {
            String s = textField.getText().toLowerCase();
            char[] chars = {
                    '\uDF00','\uDF01','\uDF02','\uDF03','\uDF04','\uDF05','\uDF06','\uDF07','\uDF08','\uDF09',
                    '\uDF10','\uDF11','\uDF12','\uDF13','\uDF14','\uDF15','\uDF16','\uDF17','\uDF18','\uDF19',
                    '\uDF20','\uDF21','\uDF22','\uDF23','\uDF24','\uDF25','\uDF26','\uDF27','\uDF28','\uDF29',
                    '\uDF30','\uDF31','\uDF32','\uDF33','\uDF34','\uDF35','\uDF36','\uDF37','\uDF38','\uDF39',
                    '\uDF40','\uDF41','\uDF42','\uDF43','\uDF44','\uDF45','\uDF46','\uDF47','\uDF48','\uDF49',
                    '\uDF50','\uDF51','\uDF52','\uDF53','\uDF54','\uDF55','\uDF56','\uDF57','\uDF58','\uDF59',
                    '\uDF60','\uDF61','\uDF62','\uDF63','\uDF64','\uDF65','\uDF66','\uDF67','\uDF68','\uDF69',
                    '\uDF70','\uDF71','\uDF72','\uDF73','\uDF74','\uDF75','\uDF76','\uDF77','\uDF78','\uDF79',
                    '\uDF80','\uDF81','\uDF82','\uDF83','\uDF84','\uDF85','\uDF86','\uDF87','\uDF88','\uDF89'
            };
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                if (showImages.get()){
                    result.append('\uD83C');
                }
                char char_ = s.charAt(i);
                if (char_ <= 'я' && char_ >= 'а'){
                    result.append(chars[char_ - 'а']);
                    continue;
                }
                if (char_ <= '9' && char_ >= '0'){
                    result.append(chars[char_ - '0' + 33]);
                    continue;
                }
                if (char_ <= 'z' && char_ >= 'a'){
                    result.append(chars[char_ - 'a' + 33 + 10]);
                    continue;
                }
                switch (char_){
                    case '!' -> result.append(chars[69]);
                    case '?' -> result.append(chars[70]);
                    case '.' -> result.append(chars[71]);
                    case ',' -> result.append(chars[72]);
                    case ':' -> result.append(chars[73]);
                    case '-' -> result.append(chars[74]);
                    case '+' -> result.append(chars[75]);
                    case '*' -> result.append(chars[76]);
                    case '/' -> result.append(chars[77]);
                    case '(' -> result.append(chars[78]);
                    case ')' -> result.append(chars[79]);
                    case '@' -> result.append(chars[80]);
                    case ';' -> result.append(chars[81]);
                    case '%' -> result.append(chars[82]);
                    case '=' -> result.append(chars[83]);
                    case 'ё' -> result.append(chars[84]);
                    default -> result.append(char_);
                }
            }

            res.setText(result.toString());
        });

        JButton changeButton = new JButton("show questions");
        changeButton.setBounds(460,220,200,100);
        changeButton.addActionListener(e -> {
            showImages.set(!showImages.get());
            if (showImages.get()){changeButton.setText("show images");}
            else changeButton.setText("show questions");
        });


        JTextArea text = new JTextArea("Some characters may not appear correctly.\n copy them to Google Docs to check");
        text.setBounds(450,340,320,40);

        JButton rus = new JButton("Русский");
        rus.setBounds(20,220,200,100);
        rus.addActionListener(e -> {
            button.setText("Шифр 1");
            button2.setText("Шифр 2");
            button3.setText("Шифр 3");
            frame.setTitle("Шифратор");
            text.setText("некоторые символы могут отоброжаться неправильно.\n скопируйте их в Google Docs чтобы проверить");
            if (Objects.equals(changeButton.getText(), "show questions")){
                changeButton.setText("показывать вопросы");
            }
            else changeButton.setText("показывать эмодзи");
        });

        JButton eng = new JButton("English");
        eng.setBounds(240,220,200,100);
        eng.addActionListener(e -> {
            button.setText("Code 1");
            button2.setText("Code 2");
            button3.setText("Code 3");
            frame.setTitle("Coder");
            text.setText("Some characters may not appear correctly.\n copy them to Google Docs to check");
        });

        frame.add(res);
        frame.add(textField);

        frame.add(eng);
        frame.add(rus);

        frame.add(button);
        frame.add(button2);
        frame.add(button3);

        frame.add(changeButton);

        frame.add(text);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
