
JUnit testaus: pelilogiikka ja käyttöliittymään liittymättömät luokat
com.ued1.punaisenpaholaisenmetsastys.hahmot.*
com.ued1.punaisenpaholaisenmetsastys.logiikka.*
com.ued1.punaisenpaholaisenmetsastys.tyokalut.NimenValidoija.java

Käsintestaus: gui, gui.logiikka
com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.*
com.ued1.punaisenpaholaisenmetsastys.gui.TarinaOsa.java
com.ued1.punaisenpaholaisenmetsastys.gui.KomentoOsa.java

KuvanLataaja.java
KuvanAsettaja.java

Luokka KuvanLataaja lataa ohjelman tarvitsemia kuvia resource/kuvat hakemistosta ja tallentaa niitä KuvanAsettajalle annettavaan Map-olioon. Luokka asettaa KuvanLataajalta saamia BufferedImage-olioita JLabel-olioiden ikoneiksi. Luokkia on testattu kokeilemalla käyttämällä keksittyjä kuviennimiä tai tahalteen kirjoitettu tiedoston nimi tai polku väärin. Puuttuvat kuvat tai virheelliset tiedostonnimet näkyvät käyttöliittymässä puuttuvina kuvina. Mikäli ohjelma ei pysty lataamaan tai ei löydä haluttua kuvaa, piirtyy kyseinen JLabel-olio ilman ikonia sisältäen pelkästään ikonin kuvauksen JLabelin tekstinä. Mikäli kuvan asettaminen onnistuu, asetetaan kuvaus ToolTip-tekstiksi.

KomennonValidoija.java
KomennonKasittelija.java
TarinaOsa.java
KomentoOsa.java

Ylläolevia luokkia on testattu pelaamalla pelia ja kokeilemalla jokaisen lisäyksen jälkeen, että käyttäjän antama komento johtaa haluttuun toimintoon. Virheet tulevat selvästi näkyviin, koska peli on event-driven tyylinen - tietyn komennon antaminen johtaa määriteltyyn toimintoon ja toimintoa vastaava näkymä päivittyy ruudulle. Pelaajan tiedot ovat myös peliruudulla jatkuvasti näkyvissä, joten esimerkiksi rahamäärän muuttuminen ja kokemuksen lisääntyminen näkyvät välittömästi käyttäjälle.

