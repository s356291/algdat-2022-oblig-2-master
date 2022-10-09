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


I Oppgave 4 så skal vi opprette metoden for indekstTil og finne posisjon og returnere -1 hvis det ikke finnes. 
Det skal også kaste null verdi, her har vi brukt for løkker. Det er trengs å opprette boolean inneholder metoden
og det returneres bare true eller false. 
