package com.example.demo.anomaly;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AnomalyConfig {
    @Bean
    CommandLineRunner commandLineRunner(AnomalyRepository repository) {
        return args -> {
            Anomaly mike = new Anomaly(
                    "Mike",
                    "Human Being"
            );
            Anomaly Beary  = new Anomaly(
                    "Beary Bearington",
                    "Beary Bearington is a large, bipedal mammal resembling a bear, measuring approximately 2 meters in height. Despite its aggressive behavior when encountered, Beary Bearington has displayed a unique fascination with cleaning objects in its environment, often utilizing a mop in its efforts. Testing has shown that Beary Bearington is capable of using the mop with a surprising level of dexterity and precision, even when attempting to clean complex or hard-to-reach areas. Further research is required to understand the anomalous properties behind Beary Bearington's affinity for cleaning."
            );
            Anomaly Snail = new Anomaly(
                    "William The Snail",
                    "William The Snail is a highly elusive gastropod mollusk, resembling a common garden snail, that has been designated as a fugitive due to its ability to evade all capture attempts by Foundation agents. Despite its seemingly mundane appearance, William The Snail has demonstrated remarkable speed, agility, and cunning in its efforts to avoid detection, leaving a trail of confusion and frustration in its wake. Foundation researchers are actively seeking new strategies to contain William The Snail and prevent its continued evasion of custody."
            );
            Anomaly Penguin = new Anomaly(
                    "William The Penguin",
                    "William The Penguin is a highly successful corporate executive who, despite its unusual species, has risen to the top of the business world with unparalleled expertise and strategic acumen. Known for its sharp wit and ruthless tactics, William The Penguin has amassed a vast fortune and a legion of loyal followers, earning the nickname \"The Emperor Penguin\" among its peers. However, Foundation intelligence reports indicate that William The Penguin has a bitter rivalry with William The Snail, a fugitive gastropod mollusk with a knack for evading capture, and may have engaged in hostile actions against it in the past."
            );
            Anomaly Dog = new Anomaly(
                    "Security Dog",
                    "Security Dog is a large, muscular canine that has been observed guarding an exotic weapons store with a fierce loyalty and vigilance. Foundation agents have reported that Security Dog is capable of wielding many of the store's weapons with surprising proficiency, and has been known to use them in self-defense against potential threats to the store or its inventory. Despite its fearsome reputation, Security Dog has shown remarkable obedience and deference to the store's proprietor, leading researchers to investigate the potential anomalous influence the proprietor may have over Security Dog."
            );
            Anomaly MothMan = new Anomaly(
                    "Moth Man",
                    "Mothman is a legendary creature from American folklore. It is described as a large, humanoid creature with wings and glowing red eyes."
            );
            Anomaly Kraken = new Anomaly(
                    "Kraken",
                    "The Kraken is a legendary sea monster, It is depicted as a giant, cephalopod-like creature with massive tentacles that can reach up to 100 feet in length."
            );
            Anomaly Nessie = new Anomaly(
                    "Loch Ness Monster",
                    "A sea creature"
            );
            Anomaly Wendigo = new Anomaly(
                    "Wendigo",
                    "A wendy boi"
            );
            Anomaly Wisp = new Anomaly(
                    "Will O'the Wisp",
                    "Wisp"
            );
            Anomaly SCP999 = new Anomaly(
                    "The Tickle Monster",
                    "Orange Happy Blob"
            );
            Anomaly Toaster = new Anomaly(
                    "A Toaster",
                    "Still a toaster"
            );
            Anomaly Walter = new Anomaly(
                    "Walter the Omnivorous Rabbit",
                    "Bunny"
            );




            repository.saveAll(
                    List.of(mike, Beary, Snail, Penguin, Dog, MothMan, Kraken, Nessie, Wendigo, Wisp, SCP999, Toaster, Walter)
            );
        };
    }
}
