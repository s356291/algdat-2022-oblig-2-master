# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Sander Sævik, s362067, s362067@oslomet.no
* Soban Ali, s362045, s362045@oslomet.no
* Pete Johansen, s356291, s356291@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Pete har hatt hovedansvar for oppgave 1, 2, og 4. 
* Sander har hatt hovedansvar for oppgave 3, 5, og 6. 
* Soban har hatt hovedansvar for oppgave 7, 8 og 9. 
* Vi har i fellesskap løst oppgave 10. 

# Oppgavebeskrivelse

I oppgave 1 så måtte vi bruke nullpointexcepetion med requirenull metode hvis a er null. Deretter sjekker vi om 
parametertabellen inneholder ikke-null verdier og oppretter hode. 
Her valgte vi å bruke for-løkke for å sjekke verdiene i Noden. 
Vi legger også inn at hvis det blir kun 1 verdi så vil det være samme node. Og etter det så legger vi inn resterende
noder og sjekker om det ikke er null verdier. Etter at vi har kjørt koden så var det feil, da testet vi litt og så at
public DobbeltLenketListe må være tom kontruktør. Etter det så gikk koden fint. 

I oppgave 2 så må vi lage toString metode. Det skal returnere tegnstreng med liste. Vi har valgt å bruke while løkke
dette gjør det enklere enn for løkkene. Det skal også opprette en omvendtStreng for som er lik toString, men omvendt rekkefølge.
Vi følger da koden fra toString og opppretter metoden på samme form. Etter det så oppretter vi metoden for leggInn metoden
som skal stoppe på null verdier og kaste en feilmelding. Det skal også sjekke om listen er tom.

I Oppgave 3, startet vi med å lage finnNode metoden. Her kom kompendiet i god hjelp. Startet med hvis indeks < antall/2 hvor man starter fra hode og går mot høyre, her brukte jeg en forløkke og nestepekere. Så lagde jeg en else statement hvis indeks ikke var mindre enn antall / 2 hvor jeg startet fra halen og gikk mot venstre ved hjelp av forrige pekere. Deretter lagde jeg metoden hent ved hjelp av finnnode, også lagde jeg oppdater, hvor den sjekker at nullverdier ikke skal kunne legges inn og at endringer variablen økes. I oppgave B lagde jeg metoden subliste, som brukte fratilkontroll og returnerte intervallene i en liste. 

I Oppgave 4 så skal vi opprette metoden for indekstTil og finne posisjon og returnere -1 hvis det ikke finnes. 
Det skal også kaste null verdi, her har vi brukt for løkker. Det er trengs å opprette boolean inneholder metoden
og det returneres bare true eller false. 

I oppgave 5 lagde jeg metoden LeggInn. Startet med å lage requirenonnullverdi. Etter det er det to situasjoner hvis hode og hale er null, og ellers. Til slutt øker mann antall og endringer og returner true.

I oppgave 6 lagde jeg fjern metodene, int indeks og T verdi. Den første fjerner og returnerer verdien på posisjonen indeks. Den andre fjerner verdi fra listen også returner true. I T verdi satt jeg opp flere if statements for å utføre oppgaven mer effektivt enn ved bruk av indekstil og int indeks. If statements, fyller ut kravene lagt i oppgaveteksten. I int indeks brukte jeg også if statements, og til slutt økte endringer, minket antall og returnerte verdien på posisjon indeks.


I oppgave 7 så skulle vi nullstillet listen. Her fant jeg en tidligere eksempel i kompendiet, som jeg brukte som utgangspunkt. Avsnitt 5.2.8 oppg 5. Her skrev jeg en while løkke (1.måte) mens (hode ikke = null). Inne i denne løkken sikret vi for at man starter i hode og vi nuller ut nodeverdien og pekerne for hver node.

Etter løkken skal hode og hale settes til null, antall til 0 og endringer økes. 

I oppgave 8 fulgte jeg bare hva oppgavene ba om
8a) Dersom iteratorendringer ikke = endringer skal vi kaste en concurrentmodificationException.
if (!hasNext()) bruker vi og kaster en Nosuchelementexception om det er ikke fler i listen 
Så setter vi fjernOK til true, og returnerer verdien og flytter til neste Node 
Ref kompendiet oppg 3.3.4 b)
8b) Her legger vi bare til return statement til DobbeltLenketListeIterator
8c) Her setter jeg pekeren til noden til den riktige indeksen.
8d) Her følger vi hva oppgaven spør om og legger til en indeksKontroll, for å sjekke om metoden er lovlig, også legger til return statement.

I oppgave 9 brukte jeg kompendiet 3.3, siden det var en lignede remove() oppgave der.

Først skulle vi lage if(!fjernOK) og kaste en illegalstateexception der tilstanden ikke går.

Etter det en if iteratorendringer ikke er lik endringer skal vi akste en concurrentmodificationexception, hvor det ikke tilsvarer

fjernOK skal settes til false. 

Så lager vi if setninger med steps 1, 2, 3, 4, (se kode for mer kommentarer)

Antall reduserer, endringer økes, og iteratorendringer økes.

I oppgave 10, så skulle vi sortere en liste ved hjelp av en komparator c. Vi kunne bare bruke metodene Liste, og det brukte vi ved å først lage to for løkker en for j og en for i hvor vi går gjennom hele liste.antall().  Deretter lager vi en if og comparer vi liste.hent j med liste hent i og setter if statement til de to mindre enn 0. Det betyr at hvis liste.hent(j) < liste.hent(i) så vil resten av koden gå gjennom hvor vi oppdaterer listen. 
