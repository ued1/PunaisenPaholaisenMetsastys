###JUnit testaus: pelilogiikka ja käyttöliittymään liittymättömät luokat
- com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.*
- com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.*
- com.ued1.punaisenpaholaisenmetsastys.tyokalut.NimenValidoija.java

JUnit-testeillä on testattu pelilogiikkaa mahdollisimman kattavasti. 444 rivistä testit kattavat 436 eli 98% ja mutanteista on tapettu 78%. Täydelliseen testaukseen ei pyritä, sillä lisätesteistä saatava hyöty olisi ajankäyttöön nähden minimaalista.

###Käsintestaus: gui, gui.logiikka, alkuvalikko, osa tyokaluista, osa peliluokista
- com.ued1.punaisenpaholaisenmetsastys.gui.*
- com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.*
- com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.*
- com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.kuuntelijat.*
- com.ued1.punaisenpaholaisenmetsastys.peli.*
- com.ued1.punaisenpaholaisenmetsastys.peli.apuvalineet.*
- com.ued1.punaisenpaholaisenmetsastys.peli.aseet.*
- com.ued1.punaisenpaholaisenmetsastys.peli.haarniskat.*

Peli on luonteeltaan sellainen, että käyttäjän antama komento aiheuttaa käyttöliittymässä usean olion ketjureaktion, jonka seurauksena mahdollisen virheen sattuessa virhe näkyisi selvästi käyttäjälle. Tämän vuoksi muut kuin pelilogiikka ja hahmo-luokat on testattu käsintestauksella kokeilemalla peliä jokaisen pienen muokkauksen jälkeen.

####KuvanLataaja.java, KuvanAsettaja.java

Luokka KuvanLataaja lataa ohjelman tarvitsemia kuvia resource/kuvat hakemistosta ja tallentaa niitä KuvanAsettajalle annettavaan Map-olioon. Luokka asettaa KuvanLataajalta saamia BufferedImage-olioita JLabel-olioiden ikoneiksi. Luokkia on testattu kokeilemalla käyttämällä keksittyjä kuviennimiä tai tahalteen kirjoitettu tiedoston nimi tai polku väärin. Puuttuvat kuvat tai virheelliset tiedostonnimet näkyvät käyttöliittymässä puuttuvina kuvina. Mikäli ohjelma ei pysty lataamaan tai ei löydä haluttua kuvaa, piirtyy kyseinen JLabel-olio ilman ikonia sisältäen pelkästään ikonin kuvauksen JLabelin tekstinä. Mikäli kuvan asettaminen onnistuu, asetetaan kuvaus ToolTip-tekstiksi.

####KomennonValidoija.java, KomennonKasittelija.java, TarinaOsa.java, KomentoOsa.java

Ylläolevia luokkia on testattu pelaamalla pelia ja kokeilemalla jokaisen lisäyksen jälkeen, että käyttäjän antama komento johtaa haluttuun toimintoon. Virheet tulevat selvästi näkyviin, koska peli on event-driven tyylinen - tietyn komennon antaminen johtaa määriteltyyn toimintoon ja toimintoa vastaava näkymä päivittyy ruudulle. Pelaajan tiedot ovat myös peliruudulla jatkuvasti näkyvissä, joten esimerkiksi rahamäärän muuttuminen ja kokemuksen lisääntyminen näkyvät välittömästi käyttäjälle.

####Alkuvalikko (useita luokkia)

Alkuvalikkoa on testattu kokeilemalla jokaisen lisätyn toiminnon jälkeen että kyseinen toiminto johtaa haluttuun tulokseen. Nimenvalintaan liittyvää NimenValidoijaa on testattu sekä JUnit-testeillä että käsin. Ohjepaneelia on testattu lisäämällä ensin Tiedostonlukija ja kokeiltu ohjelmaa ilman tarvittavaa tiedostoa.

