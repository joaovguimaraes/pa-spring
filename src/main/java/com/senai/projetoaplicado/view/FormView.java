package com.senai.projetoaplicado.view;

import com.senai.projetoaplicado.dto.CreateUserDTO;
import com.senai.projetoaplicado.presenter.UserPresenter;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.Objects;

@Route("")
public class FormView extends Div {
    public FormView(UserPresenter userPresenter) {

        Button button = new Button("Confirmar");
        FormLayout formLayout = new FormLayout();
        Dialog dialog = new Dialog();
        VerticalLayout dialogLayout = createDialogLayout(dialog);
        EmailField email = new EmailField("Email");
        TextField cpf = new TextField("Cpf");
        TextField name = new TextField("Nome");
        PasswordField password = new PasswordField("Password");
        PasswordField confirmPassword = new PasswordField("Confirm password");
        Checkbox checkbox = new Checkbox();
        Button linkButton = new Button("Ler termos", e -> dialog.open());
        H2 codigo = new H2();

        dialog.add(dialogLayout);

        cpf.setMinLength(11);
        cpf.setMaxLength(11);

        checkbox.setLabel("Eu aceito os Termos de uso.");

        linkButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        formLayout.getStyle().set("width", "75vw");
        formLayout.getStyle().set("margin", "0 auto");

        name.setRequired(true);
        cpf.setRequired(true);
        password.setRequired(true);
        confirmPassword.setRequired(true);

        password.setMinLength(6);
        name.setMinLength(3);

        formLayout.add(name, cpf, email, password, confirmPassword, checkbox, linkButton, button, codigo);
        codigo.getStyle().set("margin", "0 auto");
        formLayout.setColspan(email, 2);
        formLayout.setColspan(button, 2);
        formLayout.setColspan(checkbox, 1);
        formLayout.setColspan(codigo, 2);

        button.addClickListener(buttonClickEvent -> {
            try {
                if (name.getValue().length() <= 0 || cpf.getValue().length() <= 0 || email.getValue().length() <= 0 || password.getValue().length() <= 0 || confirmPassword.getValue().length() <= 0) {
                    throw new Exception("Preencha todos os campos");
                } else {
                    if (!name.isInvalid() && !password.isInvalid() && !cpf.isInvalid() && !email.isInvalid() && checkbox.getValue() && Objects.equals(confirmPassword.getValue(), password.getValue())) {
                        codigo.setText(
                                userPresenter.createUser(new CreateUserDTO(
                                        name.getValue(),
                                        cpf.getValue(),
                                        email.getValue(),
                                        password.getValue()
                                )).getCode());
                    } else {
                        throw new Exception("Invalido");
                    }
                }
            } catch (Exception err) {
                Notification notification = Notification
                        .show(err.getMessage());
            }
        });

        add(formLayout);
    }

    private static VerticalLayout createDialogLayout(Dialog dialog) {
        H2 headline = new H2("Termos de Uso");
        headline.getStyle().set("margin", "var(--lumo-space-m) 0")
                .set("font-size", "1.5em").set("font-weight", "bold");

        Paragraph paragraph = new Paragraph(
                "A Analytics & Co se preocupa em conscientizar seus clientes sobre as informa????es coletadas e utilizadas em seu sistema, as quais servem para proporcionar uma melhor experi??ncia de navega????o. Para isso, apresentamos nossa pol??tica de privacidade, que esclarece o uso dessas informa????es. Ao se cadastrar em nosso sistema, voc?? aceita as a????es descritas nesta pol??tica.\n" +
                        "\n" +
                        "O presente Termo de Consentimento visa registrar a manifesta????o livre e inequ??voca pela qual o Titular concorda com o tratamento dos seus dados pessoais para a finalidade espec??fica, em conformidade com a Lei n?? 13.709 ??? Lei Geral de Prote????o de Dados Pessoais (LGPD).\n" +
                        "\n" +
                        "Ao manifestar a sua aceita????o ao presente termo, o Titular consente e concorda que a Analytics & Co inscrito no CNPJ XX.XXX.XXX/0001-XX com sede na SC-401, 3730 - Saco Grande, Florian??polis-SC, doravante denominada Controladora, tome decis??es referentes ao tratamento dos seus dados pessoais abaixo descritos, necess??rios ?? presta????o dos servi??os ofertados envolvendo opera????es como as que se referem ?? coleta de:\n" +
                        "\n" +
                        "Produ????o;\n" +
                        "Recep????o;\n" +
                        "Classifica????o;\n" +
                        "Utiliza????o;\n" +
                        "Acesso;\n" +
                        "Processamento;\n" +
                        "Armazenamento;\n" +
                        "Elimina????o;\n" +
                        "Controle da informa????o;\n" +
                        "Modifica????o;\n" +
                        "Difus??o ou extra????o dos referidos dados.\n" +
                        "\n" +
                        "Para fins deste Termo de Consentimento, aplicam-se tamb??m as seguintes defini????es:\n" +
                        "\n" +
                        "Sites: qualquer p??gina da web sob o dom??nio da Controladora;\n" +
                        "IP: abreviatura de Internet Protocol. ?? um conjunto de n??meros que identifica o computador do Usu??rio na Internet;\n" +
                        "Logs: registros de atividades do Usu??rio efetuadas no site;\n" +
                        "Session ID: identifica????o da sess??o do Usu??rio no processo de inscri????o ou quando utilizado de alguma forma o site;\n" +
                        "Usu??rio: todo aquele que passar a usar o site;\n" +
                        "Sistemas: sites e/ou programas de computador que a Controladora utiliza para realizar seus processos seletivos e de matr??cula.\n" +
                        "A Analytics & Co reserva-se o direito de alterar o termo de consentimento a qualquer momento, sempre a mantendo atualizada em seu sistema. Caso queira algum esclarecimento sobre essa pol??tica, poder?? entrar em contato por meio da nossa Central de Atendimento, de segunda ?? sexta, das 9h ??s 18h, por telefone (48) 0000-0000 ou e-mail sistema@electionanalytics.com.\n" +
                        "\n" +
                        "Obten????o dos dados e informa????es\n" +
                        "\n" +
                        "Os dados e as informa????es ser??o obtidos quando o Usu??rio:\n" +
                        "\n" +
                        "1. Passar a utilizar o sistema\n" +
                        "\n" +
                        "2. Fazer o cadastro e logar no sistema\n" +
                        "\n" +
                        "Armazenamento dos Dados e das Informa????es: todos os dados e todas as informa????es coletadas dos Usu??rios ser??o incorporados ao banco de dados da Controladora, sendo esta sua respons??vel e propriet??ria. Os dados e as informa????es coletadas estar??o armazenados em ambiente seguro, observado o estado da t??cnica dispon??vel, e somente poder??o ser acessados por pessoas qualificadas e autorizadas pela Controladora. Al??m disso, a Controladora afirma que  n??o compartilhar??, vender?? ou apresentar?? os dados dos Usu??rios para terceiros que n??o sejam seus parceiros diretamente envolvidos em seus processos com as finalidades neste termo apresentadas.\n" +
                        "\n" +
                        "O Usu??rio ?? o propriet??rio dos dados e est?? apto a adicionar, excluir ou modificar quaisquer informa????es que estiverem ligadas ao seu perfil de usu??rio no sistema da Controladora. Por isso, o Usu??rio declara estar ciente e concorda com a coleta, o armazenamento, tratamento, processamento e uso das Informa????es enviadas e/ou transmitidas pelo Usu??rio nos termos estabelecidos neste Termo de Consentimento.\n" +
                        "\n" +
                        "Finalidades do Tratamento dos Dados\n" +
                        "\n" +
                        "O tratamento dos dados pessoais listados neste termo possui as seguintes finalidades:\n" +
                        "\n" +
                        "Efetuar qualquer comunica????o resultante de atividade do pr??prio sistema ou a identifica????o do respectivo destinat??rio;\n" +
                        "Fornecer acesso ??s funcionalidades do sistema;\n" +
                        "Possibilitar que a Controladora elabore estat??sticas gerais para a identifica????o do perfil dos Usu??rios;\n" +
                        "Possibilitar que a Controladora utilize tais dados em pesquisas internas de uso pr??prio.\n" +
                        "\n" +
                        "Dados Pessoais\n" +
                        "\n" +
                        "A Controladora fica autorizada a tomar decis??es referentes ao tratamento e a realizar o tratamento dos seguintes dados pessoais do Titular:\n" +
                        "\n" +
                        "Nome completo;\n" +
                        "CPF;\n" +
                        "E-mail;\n" +
                        "Senha espec??fica para acesso ao sistema da Controladora.\n" +
                        "\n" +
                        "Compartilhamento de Dados\n" +
                        "\n" +
                        "A Controladora fica autorizada a compartilhar os dados pessoais do Titular com outros agentes de tratamento de dados, caso seja necess??rio para as finalidades listadas neste termo, observados os princ??pios e as garantias estabelecidas pela Lei n?? 13.709.\n" +
                        "\n" +
                        "Seguran??a dos Dados\n" +
                        "\n" +
                        "A Controladora responsabiliza-se pela manuten????o de medidas de seguran??a, t??cnicas e administrativas aptas a proteger os dados pessoais de acessos n??o autorizados e de situa????es acidentais ou il??citas de destrui????o, perda, altera????o, comunica????o ou qualquer forma de tratamento inadequado ou il??cito.\n" +
                        "\n" +
                        "Em conformidade ao art. 48 da Lei n?? 13.709, o Controlador comunicar?? ao Titular e ?? Autoridade Nacional de Prote????o de Dados (ANPD) a ocorr??ncia de incidente de seguran??a que possa acarretar risco ou dano relevante ao Titular.\n" +
                        "\n" +
                        "T??rmino do Tratamento dos Dados\n" +
                        "\n" +
                        "A Controladora poder?? manter e tratar os dados pessoais do Titular durante todo o per??odo em que os mesmos forem pertinentes ao alcance das finalidades listadas neste termo. Dados pessoais anonimizados, sem possibilidade de associa????o ao indiv??duo, poder??o ser mantidos por per??odo indefinido.\n" +
                        "\n" +
                        "O Titular poder?? solicitar via e-mail ou correspond??ncia ?? Controladora, a qualquer momento, que sejam eliminados os dados pessoais n??o anonimizados do Titular. O Titular fica ciente de que poder?? ser invi??vel ?? Controladora continuar o fornecimento de produtos ou servi??os ao Titular a partir da elimina????o dos dados pessoais.\n" +
                        "\n" +
                        "Direitos do Titular\n" +
                        "\n" +
                        "O Titular tem direito a obter da Controladora, em rela????o aos dados por ele tratados, a qualquer momento e mediante requisi????o: I ??? confirma????o da exist??ncia de tratamento; II ??? acesso aos dados; III ??? corre????o de dados incompletos, inexatos ou desatualizados; IV ??? anonimiza????o, bloqueio ou elimina????o de dados desnecess??rios, excessivos ou tratados em desconformidade com o disposto na Lei n?? 13.709; V ??? portabilidade dos dados a outro fornecedor de servi??o ou produto, mediante requisi????o expressa e observados os segredos comercial e industrial, de acordo com a regulamenta????o do ??rg??o controlador; VI ??? elimina????o dos dados pessoais tratados com o consentimento do Titular, exceto nas hip??teses previstas no art. 16 da Lei n?? 13.709; VII ??? informa????o das entidades p??blicas e privadas com as quais a Controladora realizou uso compartilhado de dados; VIII ??? informa????o sobre a possibilidade de n??o fornecer consentimento e sobre as consequ??ncias da negativa; IX ??? revoga????o do consentimento, nos termos do ?? 5?? do art. 8?? da Lei\n" +
                        "n?? 13.709.\n" +
                        "\n" +
                        "Direito de Revoga????o do Consentimento\n" +
                        "\n" +
                        "Este consentimento poder?? ser revogado pelo usu??rio, a qualquer momento, por duas formas de solicita????o:\n" +
                        "\n" +
                        "1. E-mail: sistema@electionanalytics.com\n" +
                        "2. Correspond??ncia ao controlador: SC-401, 3730 - Saco Grande, Florian??polis - SC, 88032-005.\n");

        Button closeButton = new Button("Close");
        closeButton.addClickListener(e -> dialog.close());

        VerticalLayout dialogLayout = new VerticalLayout(headline, paragraph,
                closeButton);
        dialogLayout.setPadding(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("width", "300px").set("max-width", "100%");
        dialogLayout.setAlignSelf(FlexComponent.Alignment.END, closeButton);

        return dialogLayout;
    }
}

