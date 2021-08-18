package cdm.base.datetime;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the business centers.
 * @version ${project.version}
 */
public enum BusinessCenterEnum {
    

	/**
	 * Abu Dhabi, United Arab Emirates
	 */
	@RosettaSynonym(value = "Abu Dhabi, United Arab Emirates", source = "ISDA_Create_1_0")
	AEAD,
	    

	/**
	 * Dubai, United Arab Emirates
	 */
	AEDU,
	    

	/**
	 * Yerevan, Armenia
	 */
	@RosettaSynonym(value = "Yerevan, Armenia", source = "ISDA_Create_1_0")
	AMYE,
	    

	/**
	 * Luanda, Angola
	 */
	@RosettaSynonym(value = "Luanda, Angola", source = "ISDA_Create_1_0")
	AOLU,
	    

	/**
	 * Buenos Aires, Argentina
	 */
	@RosettaSynonym(value = "Buenos Aires, Argentina", source = "ISDA_Create_1_0")
	ARBA,
	    

	/**
	 * Vienna, Austria
	 */
	@RosettaSynonym(value = "Vienna, Austria", source = "ISDA_Create_1_0")
	ATVI,
	    

	/**
	 * Adelaide, Australia
	 */
	AUAD,
	    

	/**
	 * Brisbane, Australia
	 */
	AUBR,
	    

	/**
	 * Canberra, Australia
	 */
	@RosettaSynonym(value = "Canberra, Australia", source = "ISDA_Create_1_0")
	AUCA,
	    

	/**
	 * Darwin, Australia
	 */
	AUDA,
	    

	/**
	 * Melbourne, Australia
	 */
	AUME,
	    

	/**
	 * Perth, Australia
	 */
	AUPE,
	    

	/**
	 * Sydney, Australia
	 */
	@RosettaSynonym(value = "Sydney, Australia", source = "ISDA_Create_1_0")
	AUSY,
	    

	/**
	 * Bridgetown, Barbados
	 */
	@RosettaSynonym(value = "Bridgetown, Barbados", source = "ISDA_Create_1_0")
	BBBR,
	    

	/**
	 * Dhaka, Bangladesh
	 */
	@RosettaSynonym(value = "Dhaka, Bangladesh", source = "ISDA_Create_1_0")
	BDDH,
	    

	/**
	 * Brussels, Belgium
	 */
	@RosettaSynonym(value = "Brussels, Belgium", source = "ISDA_Create_1_0")
	BEBR,
	    

	/**
	 * Sofia, Bulgaria
	 */
	@RosettaSynonym(value = "Sofia, Bulgaria", source = "ISDA_Create_1_0")
	BGSO,
	    

	/**
	 * Manama, Bahrain
	 */
	@RosettaSynonym(value = "Manama, Bahrain", source = "ISDA_Create_1_0")
	BHMA,
	    

	/**
	 * Hamilton, Bermuda
	 */
	@RosettaSynonym(value = "Hamilton, Bermuda", source = "ISDA_Create_1_0")
	BMHA,
	    

	/**
	 * Bandar Seri Begawan, Brunei
	 */
	@RosettaSynonym(value = "Bandar Seri Begawan, Brunei Darussalam", source = "ISDA_Create_1_0")
	BNBS,
	    

	/**
	 * La Paz, Bolivia
	 */
	@RosettaSynonym(value = "La Paz, Bolivia", source = "ISDA_Create_1_0")
	BOLP,
	    

	/**
	 * Brazil Business Day. This means a business day in any of Sao Paulo, Rio de Janeiro or Brasilia not otherwise declared as a financial market holiday by the Bolsa de Mercadorias &amp; Futuros (BM&amp;F)
	 */
	BRBD,
	    

	/**
	 * Brasilia, Brazil
	 */
	@RosettaSynonym(value = "Brasília, Brazil", source = "ISDA_Create_1_0")
	BRBR,
	    

	/**
	 * Rio de Janeiro, Brazil
	 */
	BRRJ,
	    

	/**
	 * Sao Paulo, Brazil
	 */
	BRSP,
	    

	/**
	 * Nassau, Bahamas
	 */
	@RosettaSynonym(value = "Nassau, Bahamas", source = "ISDA_Create_1_0")
	BSNA,
	    

	/**
	 * Gaborone, Botswana
	 */
	@RosettaSynonym(value = "Gaborone, Botswana", source = "ISDA_Create_1_0")
	BWGA,
	    

	/**
	 * Minsk, Belarus
	 */
	@RosettaSynonym(value = "Minsk, Belarus", source = "ISDA_Create_1_0")
	BYMI,
	    

	/**
	 * Calgary, Canada
	 */
	CACL,
	    

	/**
	 * Montreal, Canada
	 */
	CAMO,
	    

	/**
	 * Ottawa, Canada
	 */
	@RosettaSynonym(value = "Ottawa-Gatineau, Canada", source = "ISDA_Create_1_0")
	CAOT,
	    

	/**
	 * Toronto, Canada
	 */
	@RosettaSynonym(value = "Toronto, Canada", source = "ISDA_Create_1_0")
	CATO,
	    

	/**
	 * Vancouver, Canada
	 */
	CAVA,
	    

	/**
	 * Winnipeg, Canada
	 */
	CAWI,
	    

	/**
	 * Basel, Switzerland
	 */
	CHBA,
	    

	/**
	 * Geneva, Switzerland
	 */
	CHGE,
	    

	/**
	 * Zurich, Switzerland
	 */
	CHZU,
	    

	/**
	 * Abidjan, Cote d&#39;Ivoire
	 */
	@RosettaSynonym(value = "Abidjan, Côte d'Ivoire", source = "ISDA_Create_1_0")
	CIAB,
	    

	/**
	 * Santiago, Chile
	 */
	@RosettaSynonym(value = "Santiago, Chile", source = "ISDA_Create_1_0")
	CLSA,
	    

	/**
	 * Beijing, China
	 */
	@RosettaSynonym(value = "Beijing, China", source = "ISDA_Create_1_0")
	CNBE,
	    

	/**
	 * Shanghai, China
	 */
	@RosettaSynonym(value = "Shanghai, China", source = "ISDA_Create_1_0")
	CNSH,
	    

	/**
	 * Bogota, Colombia
	 */
	@RosettaSynonym(value = "Bogotá, Colombia", source = "ISDA_Create_1_0")
	COBO,
	    

	/**
	 * San Jose, Costa Rica
	 */
	@RosettaSynonym(value = "San José, Costa Rica", source = "ISDA_Create_1_0")
	CRSJ,
	    

	/**
	 * Nicosia, Cyprus
	 */
	@RosettaSynonym(value = "Nicosia, Cyprus", source = "ISDA_Create_1_0")
	CYNI,
	    

	/**
	 * Prague, Czech Republic
	 */
	@RosettaSynonym(value = "Prague, Czechia", source = "ISDA_Create_1_0")
	CZPR,
	    

	/**
	 * Cologne, Germany
	 */
	DECO,
	    

	/**
	 * Dusseldorf, Germany
	 */
	DEDU,
	    

	/**
	 * Frankfurt, Germany
	 */
	@RosettaSynonym(value = "Frankfurt, Germany", source = "ISDA_Create_1_0")
	DEFR,
	    

	/**
	 * Hamburg, Germany
	 */
	DEHH,
	    

	/**
	 * Leipzig, Germany
	 */
	DELE,
	    

	/**
	 * Mainz, Germany
	 */
	DEMA,
	    

	/**
	 * Munich, Germany
	 */
	DEMU,
	    

	/**
	 * Stuttgart, Germany
	 */
	DEST,
	    

	/**
	 * Copenhagen, Denmark
	 */
	@RosettaSynonym(value = "Copenhagen, Denmark", source = "ISDA_Create_1_0")
	DKCO,
	    

	/**
	 * Santo Domingo, Dominican Republic
	 */
	@RosettaSynonym(value = "Santo Domingo, Dominican Republic", source = "ISDA_Create_1_0")
	DOSD,
	    

	/**
	 * Algiers, Algeria
	 */
	@RosettaSynonym(value = "Algiers, Algeria", source = "ISDA_Create_1_0")
	DZAL,
	    

	/**
	 * Tallinn, Estonia
	 */
	@RosettaSynonym(value = "Tallinn, Estonia", source = "ISDA_Create_1_0")
	EETA,
	    

	/**
	 * Cairo, Egypt
	 */
	@RosettaSynonym(value = "Cairo, Egypt", source = "ISDA_Create_1_0")
	EGCA,
	    

	/**
	 * ESAS Settlement Day (as defined in 2006 ISDA Definitions Section 7.1 and Supplement Number 15 to the 2000 ISDA Definitions)
	 */
	ESAS,
	    

	/**
	 * Barcelona, Spain
	 */
	ESBA,
	    

	/**
	 * Madrid, Spain
	 */
	@RosettaSynonym(value = "Madrid, Spain", source = "ISDA_Create_1_0")
	ESMA,
	    

	/**
	 * Addis Ababa, Ethiopia
	 */
	ETAA,
	    

	/**
	 * TARGET (euro &#39;Business Center&#39;)
	 */
	EUTA,
	    

	/**
	 * Helsinki, Finland
	 */
	@RosettaSynonym(value = "Helsinki, Finland", source = "ISDA_Create_1_0")
	FIHE,
	    

	/**
	 * Paris, France
	 */
	@RosettaSynonym(value = "Paris, France", source = "ISDA_Create_1_0")
	FRPA,
	    

	/**
	 * Edinburgh, Scotland
	 */
	GBED,
	    

	/**
	 * London, United Kingdom
	 */
	@RosettaSynonym(value = "London, United Kingdom", source = "ISDA_Create_1_0")
	GBLO,
	    

	/**
	 * Tbilisi, Georgia
	 */
	@RosettaSynonym(value = "Tbilisi, Georgia", source = "ISDA_Create_1_0")
	GETB,
	    

	/**
	 * Saint Peter Port, Guernsey
	 */
	GGSP,
	    

	/**
	 * Accra, Ghana
	 */
	GHAC,
	    

	/**
	 * Athens, Greece
	 */
	@RosettaSynonym(value = "Athens, Greece", source = "ISDA_Create_1_0")
	GRAT,
	    

	/**
	 * Hong Kong, Hong Kong
	 */
	@RosettaSynonym(value = "Hong Kong, China", source = "ISDA_Create_1_0")
	HKHK,
	    

	/**
	 * Tegucigalpa, Honduras
	 */
	@RosettaSynonym(value = "Tegucigalpa, Honduras", source = "ISDA_Create_1_0")
	HNTE,
	    

	/**
	 * Zagreb, Republic of Croatia
	 */
	@RosettaSynonym(value = "Zagreb, Croatia", source = "ISDA_Create_1_0")
	HRZA,
	    

	/**
	 * Budapest, Hungary
	 */
	@RosettaSynonym(value = "Budapest, Hungary", source = "ISDA_Create_1_0")
	HUBU,
	    

	/**
	 * Jakarta, Indonesia
	 */
	@RosettaSynonym(value = "Jakarta, Indonesia", source = "ISDA_Create_1_0")
	IDJA,
	    

	/**
	 * Dublin, Ireland
	 */
	@RosettaSynonym(value = "Dublin, Ireland", source = "ISDA_Create_1_0")
	IEDU,
	    

	/**
	 * Jerusalem, Israel
	 */
	@RosettaSynonym(value = "Jerusalem, Israel", source = "ISDA_Create_1_0")
	ILJE,
	    

	/**
	 * Tel Aviv, Israel
	 */
	ILTA,
	    

	/**
	 * Bangalore, India
	 */
	INBA,
	    

	/**
	 * Chennai, India
	 */
	INCH,
	    

	/**
	 * Hyderabad, India
	 */
	INHY,
	    

	/**
	 * Kolkata, India
	 */
	INKO,
	    

	/**
	 * Mumbai, India
	 */
	INMU,
	    

	/**
	 * New Delhi, India
	 */
	@RosettaSynonym(value = "New Delhi, India", source = "ISDA_Create_1_0")
	INND,
	    

	/**
	 * Tehran, Iran
	 */
	@RosettaSynonym(value = "Tehran, Iran (Islamic Republic of)", source = "ISDA_Create_1_0")
	IRTE,
	    

	/**
	 * Reykjavik, Iceland
	 */
	@RosettaSynonym(value = "Reykjavík, Iceland", source = "ISDA_Create_1_0")
	ISRE,
	    

	/**
	 * Milan, Italy
	 */
	ITMI,
	    

	/**
	 * Rome, Italy
	 */
	ITRO,
	    

	/**
	 * Turin, Italy
	 */
	ITTU,
	    

	/**
	 * St. Helier, Channel Islands, Jersey
	 */
	@RosettaSynonym(value = "St. Helier, Channel Islands", source = "ISDA_Create_1_0")
	JESH,
	    

	/**
	 * Kingston, Jamaica
	 */
	@RosettaSynonym(value = "Kingston, Jamaica", source = "ISDA_Create_1_0")
	JMKI,
	    

	/**
	 * Amman, Jordan
	 */
	@RosettaSynonym(value = "Amman, Jordan", source = "ISDA_Create_1_0")
	JOAM,
	    

	/**
	 * Tokyo, Japan
	 */
	@RosettaSynonym(value = "Tokyo, Japan", source = "ISDA_Create_1_0")
	JPTO,
	    

	/**
	 * Nairobi, Kenya
	 */
	@RosettaSynonym(value = "Nairobi, Kenya", source = "ISDA_Create_1_0")
	KENA,
	    

	/**
	 * Seoul, Republic of Korea
	 */
	@RosettaSynonym(value = "Seoul, Republic of Korea", source = "ISDA_Create_1_0")
	KRSE,
	    

	/**
	 * Kuwait City, Kuwait
	 */
	@RosettaSynonym(value = "Kuwait City, Kuwait", source = "ISDA_Create_1_0")
	KWKC,
	    

	/**
	 * George Town, Cayman Islands
	 */
	@RosettaSynonym(value = "George Town, Cayman Islands", source = "ISDA_Create_1_0")
	KYGE,
	    

	/**
	 * Almaty, Kazakhstan
	 */
	KZAL,
	    

	/**
	 * Beirut, Lebanon
	 */
	@RosettaSynonym(value = "Beirut, Lebanon", source = "ISDA_Create_1_0")
	LBBE,
	    

	/**
	 * Colombo, Sri Lanka
	 */
	@RosettaSynonym(value = "Colombo, Sri Lanka", source = "ISDA_Create_1_0")
	LKCO,
	    

	/**
	 * Luxembourg, Luxembourg
	 */
	@RosettaSynonym(value = "Luxembourg, Luxembourg", source = "ISDA_Create_1_0")
	LULU,
	    

	/**
	 * Riga, Latvia
	 */
	@RosettaSynonym(value = "Riga, Latvia", source = "ISDA_Create_1_0")
	LVRI,
	    

	/**
	 * Casablanca, Morocco
	 */
	MACA,
	    

	/**
	 * Rabat, Morocco
	 */
	@RosettaSynonym(value = "Rabat, Morocco", source = "ISDA_Create_1_0")
	MARA,
	    

	/**
	 * Monaco, Monaco
	 */
	@RosettaSynonym(value = "Monaco, Monaco", source = "ISDA_Create_1_0")
	MCMO,
	    

	/**
	 * Macau, Macao
	 */
	@RosettaSynonym(value = "Macao, China, Macao SAR", source = "ISDA_Create_1_0")
	MOMA,
	    

	/**
	 * Valletta, Malta
	 */
	@RosettaSynonym(value = "Valletta, Malta", source = "ISDA_Create_1_0")
	MTVA,
	    

	/**
	 * Port Louis, Mauritius
	 */
	@RosettaSynonym(value = "Port Louis, Mauritius", source = "ISDA_Create_1_0")
	MUPL,
	    

	/**
	 * Male, Maldives
	 */
	@RosettaSynonym(value = "Male, Maldives", source = "ISDA_Create_1_0")
	MVMA,
	    

	/**
	 * Lilongwe, Malawi
	 */
	@RosettaSynonym(value = "Lilongwe, Malawi", source = "ISDA_Create_1_0")
	MWLI,
	    

	/**
	 * Mexico City, Mexico
	 */
	@RosettaSynonym(value = "Mexico City, Mexico", source = "ISDA_Create_1_0")
	MXMC,
	    

	/**
	 * Kuala Lumpur, Malaysia
	 */
	@RosettaSynonym(value = "Kuala Lumpur, Malaysia", source = "ISDA_Create_1_0")
	MYKL,
	    

	/**
	 * Labuan, Malaysia
	 */
	MYLA,
	    

	/**
	 * Windhoek, Namibia
	 */
	@RosettaSynonym(value = "Windhoek, Namibia", source = "ISDA_Create_1_0")
	NAWI,
	    

	/**
	 * Abuja, Nigeria
	 */
	@RosettaSynonym(value = "Abuja, Nigeria", source = "ISDA_Create_1_0")
	NGAB,
	    

	/**
	 * Lagos, Nigeria
	 */
	NGLA,
	    

	/**
	 * Amsterdam, Netherlands
	 */
	@RosettaSynonym(value = "Amsterdam, Netherlands", source = "ISDA_Create_1_0")
	NLAM,
	    

	/**
	 * Rotterdam, Netherlands
	 */
	NLRO,
	    

	/**
	 * Oslo, Norway
	 */
	@RosettaSynonym(value = "Oslo, Norway", source = "ISDA_Create_1_0")
	NOOS,
	    

	/**
	 * Kathmandu, Nepal
	 */
	@RosettaSynonym(value = "Kathmandu, Nepal", source = "ISDA_Create_1_0")
	NPKA,
	    

	/**
	 * New York Fed Business Day (as defined in 2006 ISDA Definitions Section 1.9 and 2000 ISDA Definitions Section 1.9)
	 */
	NYFD,
	    

	/**
	 * New York Stock Exchange Business Day (as defined in 2006 ISDA Definitions Section 1.10 and 2000 ISDA Definitions Section 1.10)
	 */
	NYSE,
	    

	/**
	 * Auckland, New Zealand
	 */
	NZAU,
	    

	/**
	 * Wellington, New Zealand
	 */
	@RosettaSynonym(value = "Wellington, New Zealand", source = "ISDA_Create_1_0")
	NZWE,
	    

	/**
	 * Muscat, Oman
	 */
	@RosettaSynonym(value = "Masqat (Muscat), Oman", source = "ISDA_Create_1_0")
	OMMU,
	    

	/**
	 * Panama City, Panama
	 */
	@RosettaSynonym(value = "Panama City, Panama", source = "ISDA_Create_1_0")
	PAPC,
	    

	/**
	 * Lima, Peru
	 */
	@RosettaSynonym(value = "Lima, Peru", source = "ISDA_Create_1_0")
	PELI,
	    

	/**
	 * Manila, Philippines
	 */
	@RosettaSynonym(value = "Manila, Philippines", source = "ISDA_Create_1_0")
	PHMA,
	    

	/**
	 * Makati, Philippines
	 */
	PHMK,
	    

	/**
	 * Karachi, Pakistan
	 */
	PKKA,
	    

	/**
	 * Warsaw, Poland
	 */
	@RosettaSynonym(value = "Warsaw, Poland", source = "ISDA_Create_1_0")
	PLWA,
	    

	/**
	 * San Juan, Puerto Rico
	 */
	@RosettaSynonym(value = "San Juan, Puerto Rico", source = "ISDA_Create_1_0")
	PRSJ,
	    

	/**
	 * Lisbon, Portugal
	 */
	@RosettaSynonym(value = "Lisbon, Portugal", source = "ISDA_Create_1_0")
	PTLI,
	    

	/**
	 * Doha, Qatar
	 */
	@RosettaSynonym(value = "Doha, Qatar", source = "ISDA_Create_1_0")
	QADO,
	    

	/**
	 * Bucarest, Romania
	 */
	ROBU,
	    

	/**
	 * Belgrade, Serbia
	 */
	@RosettaSynonym(value = "Belgrade, Serbia", source = "ISDA_Create_1_0")
	RSBE,
	    

	/**
	 * Moscow, Russian Federation
	 */
	@RosettaSynonym(value = "Moscow, Russian Federation", source = "ISDA_Create_1_0")
	RUMO,
	    

	/**
	 * Abha, Saudi Arabia
	 */
	SAAB,
	    

	/**
	 * Jeddah, Saudi Arabia
	 */
	SAJE,
	    

	/**
	 * Riyadh, Saudi Arabia
	 */
	@RosettaSynonym(value = "Riyadh, Saudi Arabia", source = "ISDA_Create_1_0")
	SARI,
	    

	/**
	 * Stockholm, Sweden
	 */
	@RosettaSynonym(value = "Stockholm, Sweden", source = "ISDA_Create_1_0")
	SEST,
	    

	/**
	 * Singapore, Singapore
	 */
	@RosettaSynonym(value = "Singapore, Singapore", source = "ISDA_Create_1_0")
	SGSI,
	    

	/**
	 * Ljubljana, Slovenia
	 */
	@RosettaSynonym(value = "Ljubljana, Slovenia", source = "ISDA_Create_1_0")
	SILJ,
	    

	/**
	 * Bratislava, Slovakia
	 */
	@RosettaSynonym(value = "Bratislava, Slovakia", source = "ISDA_Create_1_0")
	SKBR,
	    

	/**
	 * Dakar, Senegal
	 */
	@RosettaSynonym(value = "Dakar, Senegal", source = "ISDA_Create_1_0")
	SNDA,
	    

	/**
	 * San Salvador, El Salvador
	 */
	@RosettaSynonym(value = "San Salvador, El Salvador", source = "ISDA_Create_1_0")
	SVSS,
	    

	/**
	 * Bangkok, Thailand
	 */
	@RosettaSynonym(value = "Bangkok, Thailand", source = "ISDA_Create_1_0")
	THBA,
	    

	/**
	 * Tunis, Tunisia
	 */
	@RosettaSynonym(value = "Tunis, Tunisia", source = "ISDA_Create_1_0")
	TNTU,
	    

	/**
	 * Ankara, Turkey
	 */
	@RosettaSynonym(value = "Ankara, Turkey", source = "ISDA_Create_1_0")
	TRAN,
	    

	/**
	 * Istanbul, Turkey
	 */
	TRIS,
	    

	/**
	 * Port of Spain, Trinidad and Tobago
	 */
	@RosettaSynonym(value = "Port of Spain, Trinidad and Tobago", source = "ISDA_Create_1_0")
	TTPS,
	    

	/**
	 * Taipei, Taiwan
	 */
	@RosettaSynonym(value = " Taibei, China, Taiwan Province of China", source = "ISDA_Create_1_0")
	TWTA,
	    

	/**
	 * Dar es Salaam, Tanzania
	 */
	TZDA,
	    

	/**
	 * Dodoma, Tanzania
	 */
	@RosettaSynonym(value = "Dodoma, United Republic of Tanzania", source = "ISDA_Create_1_0")
	TZDO,
	    

	/**
	 * Kiev, Ukraine
	 */
	@RosettaSynonym(value = "Kiev, Ukraine", source = "ISDA_Create_1_0")
	UAKI,
	    

	/**
	 * Kampala, Uganda
	 */
	@RosettaSynonym(value = "Kampala, Uganda", source = "ISDA_Create_1_0")
	UGKA,
	    

	/**
	 * Boston, Massachusetts, United States
	 */
	USBO,
	    

	/**
	 * Chicago, United States
	 */
	USCH,
	    

	/**
	 * Charlotte, North Carolina, United States
	 */
	USCR,
	    

	/**
	 * Washington, District of Columbia, United States
	 */
	@RosettaSynonym(value = "Washington, D.C., United States of America", source = "ISDA_Create_1_0")
	USDC,
	    

	/**
	 * Denver, United States
	 */
	USDN,
	    

	/**
	 * Detroit, Michigan, United States
	 */
	USDT,
	    

	/**
	 * U.S. Government Securities Business Day (as defined in 2006 ISDA Definitions Section 1.11 and 2000 ISDA Definitions Section 1.11)
	 */
	USGS,
	    

	/**
	 * Honolulu, Hawaii, United States
	 */
	USHL,
	    

	/**
	 * Houston, United States
	 */
	USHO,
	    

	/**
	 * Los Angeles, United States
	 */
	USLA,
	    

	/**
	 * Mobile, Alabama, United States
	 */
	USMB,
	    

	/**
	 * Minneapolis, United States
	 */
	USMN,
	    

	/**
	 * New York, United States
	 */
	@RosettaSynonym(value = "New York, United States of America", source = "ISDA_Create_1_0")
	USNY,
	    

	/**
	 * Portland, Oregon, United States
	 */
	USPO,
	    

	/**
	 * Sacramento, California, United States
	 */
	USSA,
	    

	/**
	 * Seattle, United States
	 */
	USSE,
	    

	/**
	 * Wichita, United States
	 */
	USWT,
	    

	/**
	 * Montevideo, Uruguay
	 */
	@RosettaSynonym(value = "Montevideo, Uruguay", source = "ISDA_Create_1_0")
	UYMO,
	    

	/**
	 * Caracas, Venezuela
	 */
	@RosettaSynonym(value = "Caracas, Venezuela (Bolivarian Republic of)", source = "ISDA_Create_1_0")
	VECA,
	    

	/**
	 * Road Town, Virgin Islands (British)
	 */
	@RosettaSynonym(value = "Road Town, British Virgin Islands", source = "ISDA_Create_1_0")
	VGRT,
	    

	/**
	 * Hanoi, Vietnam
	 */
	@RosettaSynonym(value = "Hà Noi, Viet Nam", source = "ISDA_Create_1_0")
	VNHA,
	    

	/**
	 * Ho Chi Minh (formerly Saigon), Vietnam
	 */
	@RosettaSynonym(value = "Ho Chi Minh (formerly Saigon), Vietnam", source = "ISDA_Create_1_0")
	VNHC,
	    

	/**
	 * Aden, Yemen
	 */
	YEAD,
	    

	/**
	 * Johannesburg, South Africa
	 */
	ZAJO,
	    

	/**
	 * Lusaka, Zambia
	 */
	@RosettaSynonym(value = "Lusaka, Zambia", source = "ISDA_Create_1_0")
	ZMLU,
	    

	/**
	 * Harare, Zimbabwe
	 */
	@RosettaSynonym(value = "Harare, Zimbabwe", source = "ISDA_Create_1_0")
	ZWHA,
	    

	/**
	 * Abu Dhabi Securities Exchange https://www.adx.ae/
	 */
	ADSM,
	    

	/**
	 * Argus Media Fertilizer Reports. http://www.argusmedia.com/Fertilizer
	 */
	AGRUSFMB,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	APPI,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	ARGUSCRUDE,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	ARGUSEUROPEANGAS,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	ARGUSEUROPEANPRODUCTS,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	ARGUSINTERNATIONALLPG,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	ARGUSMCCLOSKEYSCOALREPORT,
	    

	/**
	 * The Argus US Products report. http://www.argusmedia.com/Petroleum/Petroleum-Products/Argus-US-Products
	 */
	ARGUSUSPRODUCTS,
	    

	/**
	 * Australian Securities Exchange http://www.asx.com.au/
	 */
	ASX,
	    

	/**
	 * Australian Wheat Board. www.awb.com.au
	 */
	AWB,
	    

	/**
	 * Australian Wool Exchange. http://www.awex.com.au/home.html
	 */
	AWEX,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	BALTICEXCHANGE,
	    

	/**
	 * The business calendar of the Bank Negara Malaysia Policy Committee.
	 */
	BANKNEGARAMALAYSIAPOLICYCOMMITTEE,
	    

	/**
	 * The business calendar for the Belpex power exchange (www.belpex.be).
	 */
	BELPEX,
	    

	/**
	 * BlueNext Power Market.
	 */
	BLUENEXT,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	B_MAND_F,
	    

	/**
	 * The settlement business calendar for Bursa Malaysia.
	 */
	BURSAMALAYSIASETTLEMENT,
	    

	/**
	 * The trading business calendar for Bursa Malaysia.
	 */
	BURSAMALAYSIATRADING,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	CANADIANGASPRICEREPORTER,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	CBOTSOFT,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	CMAIAROMATICSMARKETREPORT,
	    

	/**
	 * CMAI Global Plastics and Polymers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&amp;rd=cmai
	 */
	CMAIGLOBALPLASTICSANDPOLYMERSMARKETREPORT,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	CMAIMETHANOLMARKETREPORT,
	    

	/**
	 * CMAI Monomers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&amp;rd=cmai
	 */
	CMAIMONOMERSMARKETREPORT,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	CMEDAIRY,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	CMENONDAIRYSOFT,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	COMEX,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	CRU,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	CRULONG,
	    

	/**
	 * The business calendar for statistical publications by the by the United States Department of Energy (DOE).
	 */
	DEPARTMENTOFENERGY,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	DEWITTBENZENEDERIVATIVES,
	    

	/**
	 *  Dubai Mercantile Exchange. http://www.dubaimerc.com/
	 */
	DME,
	    

	/**
	 * Dow Jones US Calendar. http://www.dowjones.com/
	 */
	DOWJONES,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	DOWJONESENERGYSERVICE,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	DOW_JONES_POWER,
	    

	/**
	 * European Energy Exchange-Coal
	 */
	EEXCOAL,
	    

	/**
	 * European Energy Exchange-Emissions Rights
	 */
	EEXEMISSIONS,
	    

	/**
	 * European Energy Exchange-Gas
	 */
	EEXGAS,
	    

	/**
	 * European Energy Exchange-Power
	 */
	EEXPOWER,
	    

	/**
	 * TBD.
	 */
	EURONEXMATIF,
	    

	/**
	 * FERTECON Limited Information Services. http://fertecon.com/current_information_services.asp
	 */
	FERTECON,
	    

	/**
	 * Fertilizer Week. http://www.crugroup.com/market-analysis/products/fertilizerweek
	 */
	FERTILIZERWEEK,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	GASDAILY,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	GASDAILYPRICEGUIDE,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	GLOBALCOAL,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	HERENREPORT,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	ICE10XDAILY,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	ICE10XMONTHLY,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	ICECANADA,
	    

	/**
	 * European Climate Exchange.
	 */
	ICEECX,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	ICEGAS,
	    

	/**
	 * The business calendar oil and refined product contracts on ICE Futures Europe.
	 */
	ICEOIL,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	ICEUSAGRICULTURAL,
	    

	/**
	 * The business calendar for publication of ICIS Benzene (Europe) data.
	 */
	ICISPRICINGBENZENEEUROPE,
	    

	/**
	 * The business calendar for publication of ICIS Ethylene (Europe) data.
	 */
	ICISPRICINGETHYLENEEUROPE,
	    

	/**
	 * The business calendar for publication of ICIS Polyproylene (Europe) data.
	 */
	ICISPRICINGPOLYPROPYLENEEUROPE,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	INSIDEFERC,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	JAPANMOFTSRR,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	KCBOT,
	    

	/**
	 * The banking business calendar in Kuala Lumpur.
	 */
	KUALALUMPURBANK,
	    

	/**
	 * The business calendar for the Labuan Bank (Malaysia).
	 */
	LABUANBANK,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	LIFFELONDONSOFT,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	LME,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	LONDONBULLIONMARKET,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	LONDONBULLIONMARKETGOLDAMONLY,
	    

	/**
	 * The London Platinum and Palladium Market in London on which members quote prices for the buying and selling of Platinum and Palladium.
	 */
	LONDONPLATINUMPALLADIUMMARKET,
	    

	/**
	 * Minneapolis Grain Exchange http://www.mgex.com/
	 */
	MGEX,
	    

	/**
	 * The business calendar for the N2EX UK power exchange (https://www.n2ex.com/aboutn2ex).
	 */
	N2EX,
	    

	/**
	 * NASDAQ-OMX (Formerly known as Nordpool). http://www.nasdaqomx.com/commodities
	 */
	NASDAQOMX,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	NATURALGASWEEK,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Article XIV.
	 */
	NERC,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	NGI,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	NGX,
	    

	/**
	 * The Nuclear Market Review report as published by Trade tech. http://www.uranium.info/nuclear_market_review.php
	 */
	NUCLEARMARKETREVIEW,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	NYMEXELECTRICITY,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	NYMEXGAS,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	NYMEXNATURALGAS,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	NYMEXOIL,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	OFFICIALBOARDMARKETS,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	OPISLPGAS,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	OPISPROPANE,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	PAPERPACKAGINGMONITOR,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	PAPERTRADER,
	    

	/**
	 * Pertamina-Indonesia. http://www.pertamina.com/
	 */
	PERTAMINA,
	    

	/**
	 * PetroChemWire Publication Calendar. http://www.petrochemwire.com/
	 */
	PETROCHEMWIRE,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	PIXPULPBENCHMARKINDICES,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	PLATTSAPAGMARKETSCAN,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	PLATTSBUNKERWIRE,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	PLATTSCLEANTANKERWIRE,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	PLATTSCRUDEOILMARKETWIRE,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	PLATTSDIRTYTANKERWIRE,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	PLATTSEUROPEANGAS,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	PLATTSEUROPEANMARKETSCAN,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	PLATTSMETALSALERT,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices
	 */
	PLATTSOILGRAM,
	    

	/**
	 * The Steel Index Iron Ore Service. http://www.thesteelindex.com/en/iron-ore
	 */
	PLATTSTSIIRONORE,
	    

	/**
	 * The Steel Index Scrap Reference Prices. http://www.thesteelindex.com/en/scrapprices
	 */
	PLATTSTSISCRAP,
	    

	/**
	 * The Steel Index. http://www.thesteelindex.com/en/price-specifications
	 */
	PLATTSTSISTEEL,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	PLATTSUSMARKETSCAN,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	PULPANDPAPERINTERNATIONAL,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	PULPANDPAPERWEEK,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	RIMPRODUCTSINTELLIGENCEDAILY,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	SAFEXSOFT,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	SFESOFT,
	    

	/**
	 * Singapore Exchange. www.sgx.com
	 */
	SGX,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	SICOM,
	    

	/**
	 * Standard and Poor&#39;s GSCI. http://us.spindices.com/index-family/commodities/sp-gsci
	 */
	SPGSCI,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	STATISTICHESBUNDESAMT,
	    

	/**
	 * Tokyo Grain Exchange. www.tge.or.jp
	 */
	TGE,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	TOCOMOIL,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	TOCOMPRECIOUS,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	TOCOMSOFT,
	    

	/**
	 * The Ux Consulting Company. http://www.uxc.com/products/uxw_overview.aspx
	 */
	UXWEEKLY,
	    

	/**
	 * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
	 */
	WORLDPULPMONTHLY    
	;

	private final String displayName;
	
	BusinessCenterEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
