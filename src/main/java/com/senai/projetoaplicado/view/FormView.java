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
                "A Analytics & Co se preocupa em conscientizar seus clientes sobre as informações coletadas e utilizadas em seu sistema, as quais servem para proporcionar uma melhor experiência de navegação. Para isso, apresentamos nossa política de privacidade, que esclarece o uso dessas informações. Ao se cadastrar em nosso sistema, você aceita as ações descritas nesta política.\n" +
                        "\n" +
                        "O presente Termo de Consentimento visa registrar a manifestação livre e inequívoca pela qual o Titular concorda com o tratamento dos seus dados pessoais para a finalidade específica, em conformidade com a Lei nº 13.709 – Lei Geral de Proteção de Dados Pessoais (LGPD).\n" +
                        "\n" +
                        "Ao manifestar a sua aceitação ao presente termo, o Titular consente e concorda que a Analytics & Co inscrito no CNPJ XX.XXX.XXX/0001-XX com sede na SC-401, 3730 - Saco Grande, Florianópolis-SC, doravante denominada Controladora, tome decisões referentes ao tratamento dos seus dados pessoais abaixo descritos, necessários à prestação dos serviços ofertados envolvendo operações como as que se referem à coleta de:\n" +
                        "\n" +
                        "Produção;\n" +
                        "Recepção;\n" +
                        "Classificação;\n" +
                        "Utilização;\n" +
                        "Acesso;\n" +
                        "Processamento;\n" +
                        "Armazenamento;\n" +
                        "Eliminação;\n" +
                        "Controle da informação;\n" +
                        "Modificação;\n" +
                        "Difusão ou extração dos referidos dados.\n" +
                        "\n" +
                        "Para fins deste Termo de Consentimento, aplicam-se também as seguintes definições:\n" +
                        "\n" +
                        "Sites: qualquer página da web sob o domínio da Controladora;\n" +
                        "IP: abreviatura de Internet Protocol. É um conjunto de números que identifica o computador do Usuário na Internet;\n" +
                        "Logs: registros de atividades do Usuário efetuadas no site;\n" +
                        "Session ID: identificação da sessão do Usuário no processo de inscrição ou quando utilizado de alguma forma o site;\n" +
                        "Usuário: todo aquele que passar a usar o site;\n" +
                        "Sistemas: sites e/ou programas de computador que a Controladora utiliza para realizar seus processos seletivos e de matrícula.\n" +
                        "A Analytics & Co reserva-se o direito de alterar o termo de consentimento a qualquer momento, sempre a mantendo atualizada em seu sistema. Caso queira algum esclarecimento sobre essa política, poderá entrar em contato por meio da nossa Central de Atendimento, de segunda à sexta, das 9h às 18h, por telefone (48) 0000-0000 ou e-mail sistema@electionanalytics.com.\n" +
                        "\n" +
                        "Obtenção dos dados e informações\n" +
                        "\n" +
                        "Os dados e as informações serão obtidos quando o Usuário:\n" +
                        "\n" +
                        "1. Passar a utilizar o sistema\n" +
                        "\n" +
                        "2. Fazer o cadastro e logar no sistema\n" +
                        "\n" +
                        "Armazenamento dos Dados e das Informações: todos os dados e todas as informações coletadas dos Usuários serão incorporados ao banco de dados da Controladora, sendo esta sua responsável e proprietária. Os dados e as informações coletadas estarão armazenados em ambiente seguro, observado o estado da técnica disponível, e somente poderão ser acessados por pessoas qualificadas e autorizadas pela Controladora. Além disso, a Controladora afirma que  não compartilhará, venderá ou apresentará os dados dos Usuários para terceiros que não sejam seus parceiros diretamente envolvidos em seus processos com as finalidades neste termo apresentadas.\n" +
                        "\n" +
                        "O Usuário é o proprietário dos dados e está apto a adicionar, excluir ou modificar quaisquer informações que estiverem ligadas ao seu perfil de usuário no sistema da Controladora. Por isso, o Usuário declara estar ciente e concorda com a coleta, o armazenamento, tratamento, processamento e uso das Informações enviadas e/ou transmitidas pelo Usuário nos termos estabelecidos neste Termo de Consentimento.\n" +
                        "\n" +
                        "Finalidades do Tratamento dos Dados\n" +
                        "\n" +
                        "O tratamento dos dados pessoais listados neste termo possui as seguintes finalidades:\n" +
                        "\n" +
                        "Efetuar qualquer comunicação resultante de atividade do próprio sistema ou a identificação do respectivo destinatário;\n" +
                        "Fornecer acesso às funcionalidades do sistema;\n" +
                        "Possibilitar que a Controladora elabore estatísticas gerais para a identificação do perfil dos Usuários;\n" +
                        "Possibilitar que a Controladora utilize tais dados em pesquisas internas de uso próprio.\n" +
                        "\n" +
                        "Dados Pessoais\n" +
                        "\n" +
                        "A Controladora fica autorizada a tomar decisões referentes ao tratamento e a realizar o tratamento dos seguintes dados pessoais do Titular:\n" +
                        "\n" +
                        "Nome completo;\n" +
                        "CPF;\n" +
                        "E-mail;\n" +
                        "Senha específica para acesso ao sistema da Controladora.\n" +
                        "\n" +
                        "Compartilhamento de Dados\n" +
                        "\n" +
                        "A Controladora fica autorizada a compartilhar os dados pessoais do Titular com outros agentes de tratamento de dados, caso seja necessário para as finalidades listadas neste termo, observados os princípios e as garantias estabelecidas pela Lei nº 13.709.\n" +
                        "\n" +
                        "Segurança dos Dados\n" +
                        "\n" +
                        "A Controladora responsabiliza-se pela manutenção de medidas de segurança, técnicas e administrativas aptas a proteger os dados pessoais de acessos não autorizados e de situações acidentais ou ilícitas de destruição, perda, alteração, comunicação ou qualquer forma de tratamento inadequado ou ilícito.\n" +
                        "\n" +
                        "Em conformidade ao art. 48 da Lei nº 13.709, o Controlador comunicará ao Titular e à Autoridade Nacional de Proteção de Dados (ANPD) a ocorrência de incidente de segurança que possa acarretar risco ou dano relevante ao Titular.\n" +
                        "\n" +
                        "Término do Tratamento dos Dados\n" +
                        "\n" +
                        "A Controladora poderá manter e tratar os dados pessoais do Titular durante todo o período em que os mesmos forem pertinentes ao alcance das finalidades listadas neste termo. Dados pessoais anonimizados, sem possibilidade de associação ao indivíduo, poderão ser mantidos por período indefinido.\n" +
                        "\n" +
                        "O Titular poderá solicitar via e-mail ou correspondência à Controladora, a qualquer momento, que sejam eliminados os dados pessoais não anonimizados do Titular. O Titular fica ciente de que poderá ser inviável à Controladora continuar o fornecimento de produtos ou serviços ao Titular a partir da eliminação dos dados pessoais.\n" +
                        "\n" +
                        "Direitos do Titular\n" +
                        "\n" +
                        "O Titular tem direito a obter da Controladora, em relação aos dados por ele tratados, a qualquer momento e mediante requisição: I – confirmação da existência de tratamento; II – acesso aos dados; III – correção de dados incompletos, inexatos ou desatualizados; IV – anonimização, bloqueio ou eliminação de dados desnecessários, excessivos ou tratados em desconformidade com o disposto na Lei nº 13.709; V – portabilidade dos dados a outro fornecedor de serviço ou produto, mediante requisição expressa e observados os segredos comercial e industrial, de acordo com a regulamentação do órgão controlador; VI – eliminação dos dados pessoais tratados com o consentimento do Titular, exceto nas hipóteses previstas no art. 16 da Lei nº 13.709; VII – informação das entidades públicas e privadas com as quais a Controladora realizou uso compartilhado de dados; VIII – informação sobre a possibilidade de não fornecer consentimento e sobre as consequências da negativa; IX – revogação do consentimento, nos termos do § 5º do art. 8º da Lei\n" +
                        "nº 13.709.\n" +
                        "\n" +
                        "Direito de Revogação do Consentimento\n" +
                        "\n" +
                        "Este consentimento poderá ser revogado pelo usuário, a qualquer momento, por duas formas de solicitação:\n" +
                        "\n" +
                        "1. E-mail: sistema@electionanalytics.com\n" +
                        "2. Correspondência ao controlador: SC-401, 3730 - Saco Grande, Florianópolis - SC, 88032-005.\n");

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

