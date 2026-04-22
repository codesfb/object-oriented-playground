import Generics.EnvelopeSystem.Envelope;
import Generics.EnvelopeSystem.Invite;
import Generics.EnvelopeSystem.Letter;
import Generics.EnvelopeSystem.Mail;

void main(){
    Letter newLetter = new Letter("Hello this is a example letter");
    Invite newInvite = new Invite("Its my aniversary");
    Envelope<Letter> letterEnvelope = new Envelope<>(newLetter);
    Envelope <Invite> InviteEnvelope = new Envelope<>(newInvite);

    System.out.println(letterEnvelope.getContent());
    System.out.println(InviteEnvelope.getContent());

    //mail
    System.out.println(Mail.imprimirConteudo(letterEnvelope, InviteEnvelope));


}
