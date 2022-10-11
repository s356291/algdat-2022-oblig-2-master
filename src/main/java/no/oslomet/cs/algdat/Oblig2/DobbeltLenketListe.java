package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.*;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    //finnNode metoden
    private Node<T> finnNode(int indeks){
     Node<T> Nodes;
     if(indeks<antall/2){
         Nodes=hode;
         for(int i=0; i<indeks; i++){//starte fra hode
             Nodes = Nodes.neste;
         }
     }
     else{//starte fra hale
         Nodes = hale;
         for(int i = antall-1; i>indeks; i--)
             Nodes = Nodes.forrige;
     }
     return Nodes;
    }

    public DobbeltLenketListe() {
        hode = hale = null;
        endringer = antall = 0;
    }

    public DobbeltLenketListe(T[] a) {
        if (a.length == 0){
            Objects.requireNonNull(a, "Tabellen er null!");
        }

        if (a.length > 0){
            int i = 0;
            for (; i < a.length; i++){      //sjekker om parametertabellen inneholder ikke null verdier og lager hode
                if(a[i] != null){
                    hode = new Node<>(a[i]);
                    antall++;
                    break;
                }
            }

            hale = hode;
            if(hode != null){           //Legger inn resten av parametabellen
                i++;
                for(; i < a.length; i++){
                    if (a[i] != null){

                        hale.neste = new Node<>(a[i], hale, null);
                        hale = hale.neste;
                        antall++;
                    }
                }
            }
        }
    }

    public Liste<T> subliste(int fra, int til) {
        fratilKontroll(antall, fra, til);
        Liste<T> liste = new DobbeltLenketListe<>();
        Node<T> her = finnNode(fra);
        for(int i = fra; i<til; i++){
            liste.leggInn(her.verdi);
            her = her.neste;
        }
        return liste;
    }

    private void fratilKontroll(int antall, int fra, int til){ //privat metode
 if(fra<0 || til>antall) {
     throw new IndexOutOfBoundsException();
 }
     if (fra>til){
         throw new IllegalArgumentException();
     }
 }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        if (hode == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean leggInn(T verdi) {

      Objects.requireNonNull(verdi, "Null verdier ikke tillatt");

      Node p = new Node(verdi, null, null);

      if(hode == null && hale == null){
          p.forrige= null;
          hode = p;
          hale = p;
          antall ++;
          endringer++;
      }else{
          hale.neste = p;
          p.forrige = hale;
          hale = p;
          antall++;
          endringer++;
      }
      return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillatt med nullverdier");
        indeksKontroll(indeks,true);
        if(antall == 0) {
            hode = hale = new Node<>(verdi, null, null);
        } else if(indeks == 0){
            hode = hode.forrige = new Node<>(verdi, null, hode);
       }
        else if(indeks == antall){
            hale = hale.neste = new Node<>(verdi, hale, null);
        }
        else{
            Node<T> p = finnNode(indeks);
            p.forrige = p.forrige.neste = new Node<>(verdi, p.forrige, p);
         }
        endringer++;
        antall++;
    }


    @Override
    public boolean inneholder(T verdi) {
        return(indeksTil(verdi) != -1);
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        Node<T> p = hode;

        for(int i = 0; i < antall; i++, p = p.neste){
            if(p.verdi.equals(verdi)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi,"ikke tillatt med null-verdier");
        indeksKontroll(indeks, false);
        Node<T> p = finnNode(indeks);
        T gVerdi = p.verdi;
        p.verdi = nyverdi;
        return gVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {

        while (hode != null){ // Skriver while løkke så går ut på at, mens hode ikke er lik null
            hode.neste = null; // Her skal vi starte i hode, som man ser
            hode.forrige = null; // så nuller vi nodeverdien og pekere for hver node
            hode = hode.neste; // Brukt kompendiet ref oppg. avsnitt 5.2.8 oppgave 5
        }

        hode = null; // Hode og
        hale = null; // hale settes til null
        antall = 0; // antall til 0
        endringer++; // endringer økes
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if(!tom()){
            s.append('[');
            Node current = hode;
            s.append(current.verdi);
            current = current.neste;
            while(current != null){
                s.append(',').append(' ').append(current.verdi);
                current = current.neste;
            }
            s.append(']');
        }else{
            s.append("[]");
        }
        return s.toString();

    }

    public String omvendtString() {
        StringBuilder s = new StringBuilder();

        if(!tom()){
            s.append('[');
            Node current = hale;
            s.append(current.verdi);
            current = current.forrige;
            while (current != null){
                s.append(',').append(' ').append(current.verdi);
                current = current.forrige;
            }
            s.append("]");

        }else{
            s.append("[]");

        }return s.toString();
    }

    @Override
    public Iterator<T> iterator() { // 8b) Lager metoden iterator og returnerer instans av iteratorklassen (dobbelenket)
       return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) { // 8d)
        indeksKontroll(indeks, false);  // Sjekker om metoden er lovlig
        return new DobbeltLenketListeIterator(indeks); // Returnere instans av iteratorklassen
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            finnNode(indeks); // 8c) Setter pekeren til noden til riktige indeksen
            denne = hode;
            fjernOK = false;
            iteratorendringer = endringer;

        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() { // 8a) metode t next()
            if (iteratorendringer != endringer){ // Sjekker først om iteratorendringer er lik endringer hvis ikke concurrentmodificationException
                throw new ConcurrentModificationException("Iteratorendringer er ikke lik endringer");}

            if (!hasNext()) { // Kaster nosuchelemntExcepiton hvis det er ikke fler i listen
                throw new NoSuchElementException("Det er ikke flere igjen i listen.");
            }

            fjernOK = true;  // Setter fjernOK til sann/true
            T denneVerdi = denne.verdi;
            denne = denne.neste;
            return denneVerdi; // returnerer verdien og flytter til neste node
            // ref kompendiet programkode 3.3.4 b)
        }
        @Override
        public void remove() {
            if (!fjernOK) {
                throw new IllegalStateException("Denne tilstanden går ikke"); // Hvis det ikke er tilatt å kalle metoden skal vi kalle en illegalstateException
            }
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException("Det tilsvarer ikke"); // Hvis endringer og iteratorendringer er forskjeligge skal vi kaste en concurrentmodificationException
            }
            fjernOK = false; // Sette fjernOK til usann/false // Remove() kan ikke kalles på nytt

            if (antall == 1  && denne == null){ // 1. Dersom antall == 1 så skal vi nulle hode og hale
                hode = null;
                hale = null;
            }
            else if (denne == null) { // 2. For å fjerne den siste må vi sette denne == null og
                hale = hale.forrige; // Hale oppdateres
                hale.neste = null;
            }
            else if (denne.forrige == hode) { // 3. For å fjerne hode (denne.forrige==hode)
            hode = denne; // Hode oppdateres
            hode.forrige = null;
            }
            else{
                Node<T> df = denne.forrige; // 4. For å fjerne en node fra listen må vi oppdatere pekere på begge sider // Hjelpevariabel
                df.forrige.neste = denne;
                denne.forrige = df.forrige;
            }

            antall--; // Antall reduseres
            endringer++; // Endringer økes
            iteratorendringer++; // Iteratorendringer økes
            // Brukt kompendiet ref Delkapittel 3.3

        }
    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


