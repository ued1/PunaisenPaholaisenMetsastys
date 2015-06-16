##Aihemäärittely

Dynaaminen seikkailupeli, jossa tavoitteena on etsiä ja tappaa kylää piinaava Punainen Paholainen. Pelaaminen tapahtuu näppäimistöllä antamalla sopiva näppäinkomento kussakin tilanteessa.

Pelialueena on kylä ja sitä ympäröivä metsä. Kylästä löytyy asepaja, haarniskakauppa, taisteluareena, parantaja, kapakka ja casino, joita apunaan käyttäen pelaaja voi vahvistaa itseään. Metsässä puolestaan taistellaan monstereita vastaan, joita tappamalla pelaaja saa rahaa (varusteiden ostamiseen) ja kokemusta (kehittyäkseen taistelijana).

Kun pelaaja on kehittynyt tarpeeksi vahvaksi, voi hän etsiä metsästä Punaisen Paholaisen luolan ja haastaa Punaisen Paholaisen taisteluun. Peli loppuu, kun pelaaja tappaa Punaisen Paholaisen.

Pelaajan ominaisuuksia ovat taso, kokemus, vointi, maksimivointi, voima (määräytyy aseen perusteella) ja puolustusvoima (määräytyy haarniskan perusteella). Lisäksi pelaajalla voi olla rahaa ja erilaisia apuvälineitä kuten vointia parantavia potioneja.

####Käyttäjät

- Pelaaja

####Toiminnat alkuvalikossa

- Uuden pelin aloittaminen
- Pelin jatkaminen
- Ohjeiden lukeminen
- Pelin asetusten vaihtaminen
- Pelin lopettaminen

####Toiminnat pelissä

- Alkuvalikkoon palaaminen
- Siirtyminen paikasta toiseen
- Monsteritaistelun aloittaminen
- Lyöminen taistelussa
- Karkuun juokseminen taistelussa
- Potionien käyttäminen
- Aseen ostaminen
- Aseen myyminen
- Haarniskan ostaminen
- Parantaminen parantajalla
- Potionien ostaminen
- Areenataistelun aloittaminen
- Casinolla pelaaminen
- Kapakassa ostaminen
- Pelin jatkaminen
- Vastaaminen toiminnon varmistamiseen

##Ohjelman rakenteellinen kuvaus

Luokat jakautuvat kolmeen erilaiseen kokonaisuuteen: alkuvalikkoluokkiin, peliluokkiin, ja käyttöliittymään.

Alkuvalikko koostuu JPanel-luokista ja niiden kuuntelijoista. Kuuntelijat antavat käskyn Kylä-oliolle, joka päivittää näkymän siirtyessä näkymästä toiseen. Kuuntelijat päivittävät myös Pelaaja-oliota.

Peliluokat jakautuvat aseisiin, haarniskoihin, apuvälineisiin, hahmoihin ja pelilogiikkaan. Hahmoja ovat Pelaaja, Kilpailija ja Monsteri. Pelilogiikka jakautuu pelissä oleviin paikkoihin: Asepaja, Haarniskakauppa, Areena, Metsa, Kapakka, Luola, Casino ja Paranta, sekä Taisteluun, joka on käytössä metsässä, luolassa ja taisteluareenalla. Pelilogiikkaluokat päivittävät, pelilogiikan hoitamisen lisäksi, pelin Hahmoja ja antavat käyttöliittymälle tarvittavia merkkijonoja ja lukuja päivittyneen pelitilanteen näyttämistä varten.

Pelin käyttöliittymä koostuu eri JPanel luokkien lisäksi käyttöliittymän logiikkaa hoitavista luokista. Pelaajan antama näppäimistökomento saa aikaan ketjun KomennonKuuntelija -> KomennonValidoija -> KomennonKasittelija -> PelitilanteenPaivittaja, missä KomennonKasittelija ohjaa pelilogiikkaa ja PelitilanteenPaivittaja antaa päivityskäskyn käyttöliittymän JPanel-olioille. Käyttöliittymä käyttää hyödyksi Pelaajan paikkatietoa (enum Paikka), minkä perusteella osa piirrettävistä kuvista ja näytettävistä teksteistä valikoituu.

Lisäksi pelissä on kuvia ja ikoneja, joita näytetään pelitilanteissa, sekä työvälineitä kuten KuvanLataaja ja NimenValidoija.

