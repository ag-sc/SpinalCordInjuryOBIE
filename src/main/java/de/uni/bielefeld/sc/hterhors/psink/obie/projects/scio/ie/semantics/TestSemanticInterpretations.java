package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics;

import java.util.regex.Matcher;

import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticAge.EAgeUnits;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticDosage.EDosagesUnits;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticTemperature.ETemperatureUnits;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticWeight.EWeightUnits;

public class TestSemanticInterpretations {

	public static void main(String[] args) {

//		age();
//		 dosage();
		// pressure();
		 weight();
//		 depth();
		// distance();
		// volume();
		// thickness();
		// temperature();
		// length();
		// force();
		// duration();
		// nnumber();
		// stderr();
//		 pValue();

	}

	public static void pValue() {

		String sampleText = "Rats were blabla (n=10) with a p value of p < 0.005 oihafigasdgf afjoaegegeg n= 12 and p > 0.005 but noiabhoghadg p  0.005";

		System.out.println(sampleText);

		Matcher matcher = SemanticPValue.PATTERN.matcher(sampleText);

		System.out.println(SemanticPValue.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: "
					+ new SemanticPValue.Builder().fromMatcher(matcher).build().normalize().asFormattedString());
			System.out.println(new SemanticPValue.Builder().fromMatcher(matcher).build());
		}
	}

	public static void stderr() {

		String sampleText = "Rats were blabla (10) oihafigasdgfasd 31 +- 0.5 afjoaegegeg n= 12";

		System.out.println(sampleText);

		Matcher matcher = SemanticStandardError.PATTERN.matcher(sampleText);

		System.out.println(SemanticStandardError.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: "
					+ new SemanticStandardError.Builder().fromMatcher(matcher).build().normalize().asFormattedString());
			System.out.println(new SemanticStandardError.Builder().fromMatcher(matcher).build());
		}
	}

	public static void stddev() {

		String sampleText = "Rats were blabla (10) oihafigasdgfasd 31 +- 0.5 afjoaegegeg n= 12";

		System.out.println(sampleText);

		Matcher matcher = SemanticStandardDeviation.PATTERN.matcher(sampleText);

		System.out.println(SemanticStandardDeviation.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: " + new SemanticStandardDeviation.Builder().fromMatcher(matcher).build()
					.normalize().asFormattedString());
			System.out.println(new SemanticStandardDeviation.Builder().fromMatcher(matcher).build());
		}
	}

	public static void nnumber() {

		String sampleText = "groups of 18 rats each blublub n = 7/group blab 5 labla ten animals and 9 rats were blabla (n=10) oihafi 18 animals asdgf afjoaegegeg n= 11 blubbel duppel n = 12";

		System.out.println(sampleText);

		Matcher matcher = SemanticNNumber.PATTERN.matcher(sampleText);

		System.out.println(SemanticNNumber.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: "
					+ new SemanticNNumber.Builder().fromMatcher(matcher).build().normalize().asFormattedString());
			System.out.println(new SemanticNNumber.Builder().fromMatcher(matcher).build());
			System.out.println(new SemanticNNumber.Builder().interprete(matcher.group()).build());
		}
	}

	public static void age() {
		/**
		 * Add:
		 * 1)  postnatal day 2 (P2) (0 day) 
		 * 2)  10- 12 weeks old...
		 *
		 * 2Y3 mo old" (0 day) "N8 wks age" (0 day)
		 */
		System.out.println(SemanticAge.convertValue(24, EAgeUnits.hour, EAgeUnits.hour));
		System.out.println(SemanticAge.convertValue(24, EAgeUnits.hour, EAgeUnits.day));
		System.out.println(SemanticAge.convertValue(24, EAgeUnits.hour, EAgeUnits.week));
		System.out.println(SemanticAge.convertValue(24, EAgeUnits.hour, EAgeUnits.year));
		System.out.println("");
		System.out.println(SemanticAge.convertValue(7, EAgeUnits.day, EAgeUnits.hour));
		System.out.println(SemanticAge.convertValue(7, EAgeUnits.day, EAgeUnits.day));
		System.out.println(SemanticAge.convertValue(7, EAgeUnits.day, EAgeUnits.week));
		System.out.println("");
		System.out.println(SemanticAge.convertValue(1, EAgeUnits.week, EAgeUnits.hour));
		System.out.println(SemanticAge.convertValue(1, EAgeUnits.week, EAgeUnits.day));
		System.out.println(SemanticAge.convertValue(4, EAgeUnits.week, EAgeUnits.month));
		System.out.println("");
		System.out.println(SemanticAge.convertValue(1, EAgeUnits.month, EAgeUnits.week));
		System.out.println(SemanticAge.convertValue(1, EAgeUnits.month, EAgeUnits.day));
		System.out.println(SemanticAge.convertValue(4, EAgeUnits.month, EAgeUnits.month));
		System.out.println("");
		System.out.println(SemanticAge.convertValue(1, EAgeUnits.year, EAgeUnits.hour));
		System.out.println(SemanticAge.convertValue(1, EAgeUnits.year, EAgeUnits.day));
		System.out.println(SemanticAge.convertValue(4, EAgeUnits.year, EAgeUnits.month));

		System.out.println("");

		SemanticAge w1 = new SemanticAge.Builder().setUnit(EAgeUnits.day).setVarianceValue(14).setMeanValue(28).build();

		System.out.println(w1.convertTo(EAgeUnits.hour));
		System.out.println(w1.convertTo(EAgeUnits.day));
		System.out.println(w1.convertTo(EAgeUnits.week));
		System.out.println(w1.convertTo(EAgeUnits.month));
		System.out.println(w1.convertTo(EAgeUnits.year));

		String ageSampleText = "kskfhsudg 10–12 weeks old vbkjf sdg 12 weeks old  a s fhnsig2days to 21 days 1 day to ten day 1 days to 21 days iuagiugigi Six- to eight-week-old 8 weeks 3 months of age 8 to 2 month Chonadult 2.711 in p sensory axons 3 months to 8 days, blablab 1 day to 21 days";
		// String ageSampleText = "Six- to eight-week-old";
		Matcher matcher = SemanticAge.PATTERN.matcher(ageSampleText);
		System.out.println();
		System.out.println(SemanticAge.PATTERN.pattern().replaceAll("\\?<.+?>", ""));
		System.out.println();
		while (matcher.find()) {
			System.out.println(new SemanticAge.Builder().fromMatcher(matcher).build());
		}
	}

	public static void dosage() {

		System.out.println(SemanticDosage.convertValue(1, EDosagesUnits.mg_kg, EDosagesUnits.g_g));
		System.out.println(SemanticDosage.convertValue(1, EDosagesUnits.mg_kg, EDosagesUnits.g_kg));
		System.out.println(SemanticDosage.convertValue(1, EDosagesUnits.mg_kg, EDosagesUnits.µg_kg));
		System.out.println(SemanticDosage.convertValue(1, EDosagesUnits.µg_kg, EDosagesUnits.mg_kg));
		System.out.println(SemanticDosage.convertValue(1, EDosagesUnits.g_kg, EDosagesUnits.mg_g));
		System.out.println(SemanticDosage.convertValue(1, EDosagesUnits.µg_kg, EDosagesUnits.g_kg));

		System.out.println("");
		/**
		 * Difficulties: 6 �l of 10 U/ml 0.1 or 4 mg per kg
		 */
		String dosageSampleText = "streptomycin (100 IU/ml; Invitrogen) 21mixed with 3 mL of 1% H3PO4 and 1 mL 0.6% thiobarbi oin-"
				+ "treated group; 1 mL physiological  injection of 1 mL physiological saline 1 mL blablabla"
				+ " fifteen mL and to 25 mL were anaesthetised with 3% isoflurane in a gas difference is with"
				+ " a dosage of 5% sometimes 3 %  but up to 3-5% that in normal cases the thing that "
				+ "has the 150 i.u./kg blub found out that bla 3,5 U foguasdf Adult males (285330 g) "
				+ "and females 254 �mol/kg mnbvcxy 108 cfu/ml qwertzui 0.03 mgkg of body weight "
				+ "sfhjsgoidg 10,000 unitskg-bw lskdfhosodg Fifteen to 25 ml MgSO4, 300 mg/kg (n=10) or (3) 2.38 mg / day  "
				+ "ikloghf obasf Ab: 3 mg/ml, 5 �l/h, 3,1 �g IgG/ml recieved"
				+ " blabalb 1.19 mg of AS per day jojosj asogb 100 unitskg-bw concentration "
				+ "of 0.1 or 4 mg per kg of body weight or 3. Saline, 1 cm3 . 5000 IU hsäodgh 0.2 mg in 0.1 ml kasfibva"
				+ " 2.38 mg per day blabl 10mg/kg-body weight balbbl 10,000 g/l This pump they received 0.1 g saline"
				+ " continuously 1,000 IU delivered 0.25 L/h of an inosine solution 2 mg in 0.1 ml blablablsf 5,000 gkg-bw bublabödfagf";

		Matcher matcher = SemanticDosage.PATTERN.matcher(dosageSampleText);
		System.out.println(SemanticDosage.PATTERN.pattern().replaceAll("\\?<.+?>", ""));
		System.out.println(SemanticDosage.PATTERN.pattern());

		while (matcher.find()) {
			// for (int i = 0; i < matcher.groupCount(); i++) {
			// System.out.println(i + ": " + matcher.group(i));
			// }
			System.out.println(new SemanticDosage.Builder().interprete((matcher.group())).build());
			System.out.println(new SemanticDosage.Builder().fromMatcher(matcher).build());
			System.out.println(new SemanticDosage.Builder().fromMatcher(matcher).build().normalize());
		}
	}

	public static void pressure() {
		/**
		 * Difficulties: 6 �l of 10 U/ml 0.1 or 4 mg per kg
		 */
		String dosageSampleText = "20 µl x 10 min mmmmmmmm 12.5 µl x 5 min qwertzuio 5 bars";

		Matcher matcher = SemanticPressure.PATTERN.matcher(dosageSampleText);
		System.out.println(SemanticPressure.PATTERN.pattern().replaceAll("\\?<.+?>", ""));
		System.out.println(SemanticPressure.PATTERN.pattern());

		while (matcher.find()) {
			// for (int i = 0; i < matcher.groupCount(); i++) {
			// System.out.println(i + ": " + matcher.group(i));
			// }
			System.out.println(new SemanticPressure.Builder().fromMatcher(matcher).build());
			System.out.println(new SemanticPressure.Builder().fromMatcher(matcher).build().normalize());
		}
	}

	public static void weight() {

		System.out.println(SemanticWeight.PATTERN);

		System.out.println(SemanticWeight.convertValue(1, EWeightUnits.mg, EWeightUnits.mg));
		System.out.println(SemanticWeight.convertValue(1, EWeightUnits.mg, EWeightUnits.g));
		System.out.println(SemanticWeight.convertValue(1, EWeightUnits.mg, EWeightUnits.kg));
		System.out.println("");
		System.out.println(SemanticWeight.convertValue(1, EWeightUnits.g, EWeightUnits.mg));
		System.out.println(SemanticWeight.convertValue(1, EWeightUnits.g, EWeightUnits.g));
		System.out.println(SemanticWeight.convertValue(1, EWeightUnits.g, EWeightUnits.kg));
		System.out.println("");
		System.out.println(SemanticWeight.convertValue(1, EWeightUnits.kg, EWeightUnits.mg));
		System.out.println(SemanticWeight.convertValue(1, EWeightUnits.kg, EWeightUnits.g));
		System.out.println(SemanticWeight.convertValue(1, EWeightUnits.kg, EWeightUnits.kg));

		System.out.println("");

		SemanticWeight w1 = new SemanticWeight.Builder().setUnit(EWeightUnits.mg).setVarianceValue(10).setMeanValue(100)
				.build();

		System.out.println(w1.convertTo(EWeightUnits.mg));
		System.out.println(w1.convertTo(EWeightUnits.g));
		System.out.println(w1.convertTo(EWeightUnits.kg));
		System.out.println(w1.convertTo(EWeightUnits.t));
		System.out.println(w1.normalize());

		String sampleText = "Eighty-one adult Sprague Dawley rats (300–400 gm; Taconic Farms, Germantown, NY) were used in this stu Sprague-Dawley rats (200–250 gm) were us blubble 200–240 grams Adult males (285330 g) and females 3031 mg/kg asdfghj"
				+ "kldfghjkl 40lbs hello world 100 g x cm   bjdsbg"
				+ "vohdsago 20 g 20kilo tlongabcd 210 and 310 g jbsfkbjsf -term balb, 0.5 g between 0.05, 4mg deli"
				+ "ver along /100g promote functiona sasddf~300 g Adult female Sprague Dawley rats (~200 kg; Harlan Laboratories"
				+ ") adult female weighing 30 g Long Evans,0.1 mg rats (280g to 300 g) Hsp27 gene expression 250 g ± 30 mg SO4 given minocycline in a rat "
				+ "model of SCI signi®cantly preserves axonal young weighing between 210 and 310 g "
				+ "were used s (220280g; n=88; The rats weighing 200+-10g,"
				+ " and their... weighing 270\n300 kilo. 94509455]. We Young adult (about 400g) bla blubs"
				+ " (~400 g) female guinea pigs. weighing 200-250 g were used weighing "
				+ "200250 g were male (285300 g) and female (192268 g) Sprague-Dawley rats weighing 192� 268 g";

		System.out.println(sampleText);

		Matcher matcher = SemanticWeight.PATTERN.matcher(sampleText);

		System.out.println(SemanticWeight.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: "
					+ new SemanticWeight.Builder().fromMatcher(matcher).build().normalize().asFormattedString());
			System.out.println(new SemanticWeight.Builder().fromMatcher(matcher).build());
		}
	}

	public static void depth() {

		System.out.println(SemanticDepth.PATTERN);

		String sampleText = "10 mm oiuztrew 100 cm blub  0.001 µm";

		System.out.println(sampleText);

		Matcher matcher = SemanticDepth.PATTERN.matcher(sampleText);

		System.out.println(SemanticDepth.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: "
					+ new SemanticDepth.Builder().fromMatcher(matcher).build().normalize().asFormattedString());
			System.out.println(new SemanticDepth.Builder().fromMatcher(matcher).build());
		}
	}

	public static void distance() {

		System.out.println(SemanticDistance.PATTERN);

		String sampleText = "10 mm oiuztrew 100 cm blub  0.001 µm";

		System.out.println(sampleText);

		Matcher matcher = SemanticDistance.PATTERN.matcher(sampleText);

		System.out.println(SemanticDistance.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: "
					+ new SemanticDistance.Builder().fromMatcher(matcher).build().normalize().asFormattedString());
			System.out.println(new SemanticDistance.Builder().fromMatcher(matcher).build());
		}
	}

	public static void volume() {

		System.out.println(SemanticVolume.PATTERN);

		String sampleText = "10 µl oiuztrew 100 cm 3 blub  0.001 l";

		System.out.println(sampleText);

		Matcher matcher = SemanticVolume.PATTERN.matcher(sampleText);

		System.out.println(SemanticVolume.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: "
					+ new SemanticVolume.Builder().fromMatcher(matcher).build().normalize().asFormattedString());
			System.out.println(new SemanticVolume.Builder().fromMatcher(matcher).build());
		}
	}

	public static void thickness() {

		System.out.println(SemanticThickness.PATTERN);

		String sampleText = "10 mm oiuztrew 100 cm blub  0.001 µm";

		System.out.println(sampleText);

		Matcher matcher = SemanticThickness.PATTERN.matcher(sampleText);

		System.out.println(SemanticThickness.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: "
					+ new SemanticThickness.Builder().fromMatcher(matcher).build().normalize().asFormattedString());
			System.out.println(new SemanticThickness.Builder().fromMatcher(matcher).build());
		}
	}

	public static void temperature() {

		System.out.println(SemanticTemperature.PATTERN);

		SemanticTemperature t1 = new SemanticTemperature.Builder().setUnit(ETemperatureUnits.c).setVarianceValue(10)
				.setMeanValue(100).build();

		String sampleText = "20-30°C asdfghjklöä 20 ° C qwertzui 20°C +-10 yxcvbn 33�C iuztrewq 33�Celsius lkjhgtfdsa 23.8 +/- 0.9�C";

		System.out.println(sampleText);

		Matcher matcher = SemanticTemperature.PATTERN.matcher(sampleText);

		System.out.println(SemanticTemperature.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: "
					+ new SemanticTemperature.Builder().fromMatcher(matcher).build().normalize().asFormattedString());
			System.out.println(new SemanticTemperature.Builder().fromMatcher(matcher).build());
		}
	}

	public static void length() {

		System.out.println(SemanticLength.PATTERN);

		String sampleText = "10 mm oiuztrew 100 cm blub  0.001 µm";

		System.out.println(sampleText);

		Matcher matcher = SemanticLength.PATTERN.matcher(sampleText);

		System.out.println(SemanticLength.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: "
					+ new SemanticLength.Builder().fromMatcher(matcher).build().normalize().asFormattedString());
			System.out.println(new SemanticLength.Builder().fromMatcher(matcher).build());
		}
	}

	public static void force() {

		String dosageSampleText = "150 kdynes iuasgfigasoif 3, n=6) abcdefghijklmnopqrstuvwxyz 200-260 dyns kjhgfdsa 10 g x 12.5 mm qwertzuio 1 N lkjhgfdsa 0.5 N yxcvbnm 10 g x 12.5 mm lkjhgfdsa 150 g-cm lkjhgfdsa 150 kdyns qwertzu 100000 dyn";

		Matcher matcher = SemanticForce.PATTERN.matcher(dosageSampleText);
		System.out.println(SemanticForce.PATTERN.pattern().replaceAll("\\?<.+?>", ""));
		System.out.println(SemanticForce.PATTERN.pattern());

		while (matcher.find()) {
			System.out.println(new SemanticForce.Builder().fromMatcher(matcher).build());
			System.out.println(new SemanticForce.Builder().fromMatcher(matcher).build().normalize());
		}
	}

	public static void duration() {

		System.out.println(SemanticDuration.PATTERN);

		String sampleText = "10 mins oiuztrew 100 seconds blub  100 h";

		System.out.println(sampleText);

		Matcher matcher = SemanticDuration.PATTERN.matcher(sampleText);

		System.out.println(SemanticDuration.PATTERN.pattern().replaceAll("\\?<.+?>", ""));

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("norm: "
					+ new SemanticDuration.Builder().fromMatcher(matcher).build().normalize().asFormattedString());
			System.out.println(new SemanticDuration.Builder().fromMatcher(matcher).build());
		}
	}

}
