package cdm.legalagreement.csa;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The ISDA Collateral Assets Definitions as published by ISDA in the 2003 ISDA Collateral Asset Definitions.
 * @version ${project.version}
 */
public enum CollateralAssetDefinitionsEnum {
    

	/**
	 * Australian Dollar (AUD) Cash.
	 */
	AU_CASH,
	    

	/**
	 * Australian Government Securities Capital-Indexed Bonds.
	 */
	AU_CIB("AU-CIB"),
	

	/**
	 * Australian Semi-Government Securities Fixed Interest Bonds.
	 */
	AU_FIB("AU-FIB"),
	

	/**
	 * Australian Government Securities Fixed Rate Bonds.
	 */
	AU_FRB("AU-FRB"),
	

	/**
	 * Australian Semi-Government Securities Index Linked Bonds.
	 */
	AU_ILB("AU-ILB"),
	

	/**
	 * Australian Government Securities Treasury Notes.
	 */
	AU_NOTE("AU-NOTE"),
	

	/**
	 * Australian Semi-Government Securities Treasury Notes.
	 */
	AU_STATENOTE("AU-STATENOTE"),
	

	/**
	 * Australian Government Securities Treasury Adjustable Rate Bonds.
	 */
	AU_TAB("AU-TAB"),
	

	/**
	 * BEL20 Equity Securities.
	 */
	BE_BEL20("BE-BEL20"),
	

	/**
	 * Belgian Treasury Certificates.
	 */
	BE_CERT("BE-CERT"),
	

	/**
	 * Belgian Linear Obligations.
	 */
	BE_LINEAR("BE-LINEAR"),
	

	/**
	 * Belgian Treasury notes.
	 */
	BE_NOTE("BE-NOTE"),
	

	/**
	 * Public sector issues guaranteed by Regional Authorities.
	 */
	BE_REGIONGT("BE-REGIONGT"),
	

	/**
	 * Public sector issues guaranteed by the Belgian State.
	 */
	BE_STATEGT("BE-STATEGT"),
	

	/**
	 * Belgian State Loans.
	 */
	BE_STATELOAN("BE-STATELOAN"),
	

	/**
	 * Canada Bonds.
	 */
	CA_BOND("CA-BOND"),
	

	/**
	 * Canadian Dollar (CAD) Cash.
	 */
	CA_CASH("CA-CASH"),
	

	/**
	 * Government of Canada Real Return Bonds.
	 */
	CA_RRB("CA-RRB"),
	

	/**
	 * Government of Canada Treasury Bills.
	 */
	CA_TBILL("CA-TBILL"),
	

	/**
	 * Public Authority Bond.
	 */
	CH_CANTON("CH-CANTON"),
	

	/**
	 * Swiss Franc (CHF) Cash.
	 */
	CH_CASH("CH-CASH"),
	

	/**
	 * Federal Bond.
	 */
	CH_FEDBOND("CH-FEDBOND"),
	

	/**
	 * Unverzinsliche Schatzanweisungen (Bills).
	 */
	DE_BILL("DE-BILL"),
	

	/**
	 * Bundesanleihen (Bonds).
	 */
	DE_BOND("DE-BOND"),
	

	/**
	 * Negotiable Debt Obligations issued by or taken over and since serviced and managed by the Erblasttilgungsfond (Redemption Fund for Inherited Liabilities) backed by Federal Republic of Germany, including but not limited to former issues of the Treuhandanstalt, the Bundesbahn, the Bundespost, the Economic Recovery Program (ERP), the privatised Federal Railway (Bahn AG), the telecommunications element of the Federal Post Office (Telekom) and the German Unity Fund.
	 */
	DE_ERBLAST("DE-ERBLAST"),
	

	/**
	 * Kommunalschuldverschreib	ungen (Municipal Bonds).
	 */
	DE_MUNI("DE-MUNI"),
	

	/**
	 * Bundesschatzanweisungen (Notes).
	 */
	DE_NOTE2("DE-NOTE2"),
	

	/**
	 * Bundesobligationen (Notes).
	 */
	DE_NOTE5_5("DE-NOTE5.5"),
	

	/**
	 * Hypothekenpfandbriefe (Mortgage Bonds).
	 */
	DE_PFAND("DE-PFAND"),
	

	/**
	 * Skatkammerbeviser (Treasury Bills).
	 */
	DK_BILL("DK-BILL"),
	

	/**
	 * BoligX obligationer.
	 */
	DK_BOLIGX("DK-BOLIGX"),
	

	/**
	 * Statsobligationer (Government Bonds).
	 */
	DK_BOND("DK-BOND"),
	

	/**
	 * Callable Mortgage Bonds.
	 */
	DK_CALLMORT("DK-CALLMORT"),
	

	/**
	 * Danish Krone (DKK) Cash.
	 */
	DK_CASH("DK-CASH"),
	

	/**
	 * KFX Equity Securities.
	 */
	DK_KFX("DK-KFX"),
	

	/**
	 * Non-callable Mortgage Bonds.
	 */
	DK_MORT("DK-MORT"),
	

	/**
	 * Statsgaeldsbeviser (Treasury Notes).
	 */
	DK_NOTE("DK-NOTE"),
	

	/**
	 * Treasury Bills - Letras del Tesoro.
	 */
	ES_BILL("ES-BILL"),
	

	/**
	 * Public Government Debt.
	 */
	ES_BOND("ES-BOND"),
	

	/**
	 * Cedulas.
	 */
	ES_CEDULAS("ES-CEDULAS"),
	

	/**
	 * Corporate Bonds.
	 */
	ES_CORP("ES-CORP"),
	

	/**
	 * Equity securities issued by a Spanish company, and listed as an IBEX 35 constituent company as reported by the Sociedad de Bolsas, each share representing the minimum unit of participation of a shareholder in the stock capital of the company.
	 */
	ES_EQUITY("ES-EQUITY"),
	

	/**
	 * Euro (EUR) Cash.
	 */
	EU_CASH("EU-CASH"),
	

	/**
	 * FTSE Euro 100 Index Equity Securities.
	 */
	EU_EURO100("EU-EURO100"),
	

	/**
	 * FTSE Eurotop 300 Index Equity Securities.
	 */
	EU_EUROTOP300("EU-EUROTOP300"),
	

	/**
	 * EuroSTOXX 50 Index Equity Securities.
	 */
	EU_STOXX50("EU-STOXX50"),
	

	/**
	 * STOXX 600 Index Equity Securities.
	 */
	EU_STOXX600("EU-STOXX600"),
	

	/**
	 * Treasury bills.
	 */
	FI_BILL("FI-BILL"),
	

	/**
	 * Serial bonds (Finnish Government Bond).
	 */
	FI_BOND("FI-BOND"),
	

	/**
	 * HEX Equity Securities.
	 */
	FI_HEX("FI-HEX"),
	

	/**
	 * Commercial Paper: (Billet de Trésorerie).
	 */
	FR_BDT("FR-BDT"),
	

	/**
	 * Treasury Notes: Bons du Trésor à Taux Annuel (BTAN).
	 */
	FR_BTAN("FR-BTAN"),
	

	/**
	 * Treasury Bills: Bons du Trésor à Taux Fixe (BTF).
	 */
	FR_BTF("FR-BTF"),
	

	/**
	 * Government bonds: Obligations Assimilables du Trésor (OAT).
	 */
	FR_OAT("FR-OAT"),
	

	/**
	 * STRIPS.
	 */
	FR_STRIP("FR-STRIP"),
	

	/**
	 * Generally Accepted Australian Government Obligations.
	 */
	GA_AU_GOV("GA-AU-GOV"),
	

	/**
	 * Generally Accepted Belgian Government Obligations.
	 */
	GA_BE_GOV("GA-BE-GOV"),
	

	/**
	 * Generally Accepted Canadian Government Obligations.
	 */
	GA_CA_GOV("GA-CA-GOV"),
	

	/**
	 * Generally Accepted Swiss Government Obligations.
	 */
	GA_CH_GOV("GA-CH-GOV"),
	

	/**
	 * Generally Accepted German Government Obligations.
	 */
	GA_DE_GOV("GA-DE-GOV"),
	

	/**
	 * Generally Accepted Danish Government Obligations.
	 */
	GA_DK_GOV("GA-DK-GOV"),
	

	/**
	 * Generally Accepted Spanish Government Obligations.
	 */
	GA_ES_GOV("GA-ES-GOV"),
	

	/**
	 * Generally Accepted Euro Zone Government Securities.
	 */
	GA_EUROZONE_GOV("GA-EUROZONE-GOV"),
	

	/**
	 * Generally Accepted EU Member State Government Securities.
	 */
	GA_EU_GOV("GA-EU-GOV"),
	

	/**
	 * Generally Accepted Finnish Government Obligations.
	 */
	GA_FI_GOV("GA-FI-GOV"),
	

	/**
	 * Generally Accepted French Government Obligations.
	 */
	GA_FR_GOV("GA-FR-GOV"),
	

	/**
	 * Generally Accepted G5 Government Obligations.
	 */
	GA_G5_GOV("GA-G5-GOV"),
	

	/**
	 * Generally Accepted British Government Obligations.
	 */
	GA_GB_GOV("GA-GB-GOV"),
	

	/**
	 * Generally Accepted Hong Kong Government Obligations.
	 */
	GA_HK_GOV("GA-HK-GOV"),
	

	/**
	 * Generally Accepted Italian Government Obligations.
	 */
	GA_IT_GOV("GA-IT-GOV"),
	

	/**
	 * Generally Accepted Japanese Government Obligations.
	 */
	GA_JP_GOV("GA-JP-GOV"),
	

	/**
	 * Generally Accepted Korean Government Obligations.
	 */
	GA_KR_GOV("GA-KR-GOV"),
	

	/**
	 * Generally Accepted Netherlands Government Obligations.
	 */
	GA_NL_GOV("GA-NL-GOV"),
	

	/**
	 * Generally Accepted Norwegian Government Obligations.
	 */
	GA_NO_GOV("GA-NO-GOV"),
	

	/**
	 * Generally Accepted New Zealand Government Obligations.
	 */
	GA_NZ_GOV("GA-NZ-GOV"),
	

	/**
	 * Generally Accepted Swedish Government Obligations.
	 */
	GA_SE_GOV("GA-SE-GOV"),
	

	/**
	 * Generally Accepted Singaporean Government Obligations.
	 */
	GA_SG_GOV("GA-SG-GOV"),
	

	/**
	 * Generally Accepted US Agency Obligations.
	 */
	GA_US_AGENCY("GA-US-AGENCY"),
	

	/**
	 * Generally Accepted US Government Obligations.
	 */
	GA_US_GOV("GA-US-GOV"),
	

	/**
	 * Generally Accepted US Mortgage-Backed Obligations.
	 */
	GA_US_MORTGAGES("GA-US-MORTGAGES"),
	

	/**
	 * British Pound Sterling (GBP) Cash.
	 */
	GB_CASH("GB-CASH"),
	

	/**
	 * Double-dated Gilts.
	 */
	GB_DDGILT("GB-DDGILT"),
	

	/**
	 * FTSE 100 Equity Securities.
	 */
	GB_FT100("GB-FT100"),
	

	/**
	 * FTSE 250 Equity Securities.
	 */
	GB_FT250("GB-FT250"),
	

	/**
	 * FTSE 350 Equity Securities.
	 */
	GB_FT350("GB-FT350"),
	

	/**
	 * Conventional Gilts.
	 */
	@RosettaSynonym(value = "UK Gilts", source = "ISDA_Create_1_0")
	GB_GILT("GB-GILT"),
	

	/**
	 * Index-Linked Gilts.
	 */
	GB_INDEXGILT("GB-INDEXGILT"),
	

	/**
	 * Undated or Perpetual Gilts.
	 */
	GB_PERPGILT("GB-PERPGILT"),
	

	/**
	 * Rump Stock.
	 */
	GB_RUMPGILT("GB-RUMPGILT"),
	

	/**
	 * Bank of England Euro Bills.
	 */
	GB_SUPR1("GB-SUPR1"),
	

	/**
	 * Bank of England Euro Notes.
	 */
	GB_SUPR2("GB-SUPR2"),
	

	/**
	 * UK Treasury Bills.
	 */
	GB_TBILL("GB-TBILL"),
	

	/**
	 * Gilt Strips or Zero Coupon Gilts.
	 */
	GB_ZEROGILT("GB-ZEROGILT"),
	

	/**
	 * Hong Kong Government Exchange Fund Bills.
	 */
	HK_BILL("HK-BILL"),
	

	/**
	 * Hong Kong Dollar (HKD) Cash.
	 */
	HK_CASH("HK-CASH"),
	

	/**
	 * Hong Kong Government Exchange Fund Notes.
	 */
	HK_NOTE("HK-NOTE"),
	

	/**
	 * Botbuoni Ordinari del Tesoro (BOT) zero coupon debt securities issued by the Italian Treasury with maturities up to 365 days.
	 */
	IT_BOT("IT-BOT"),
	

	/**
	 * Buoni del Tesoro Poliennali fixed interest semi-annual debt securities issued by the Italian Treasury with original maturities between 3 and 30 years.
	 */
	IT_BTP("IT-BTP"),
	

	/**
	 * Certificati di Credito del Tesoro a Cedola Variable (CCT) or floating rate interest bearing debt securities issued by the Italian Treasury.
	 */
	IT_CCT("IT-CCT"),
	

	/**
	 * Corporate bonds.
	 */
	IT_CORP("IT-CORP"),
	

	/**
	 * Certificati del Tesoro zero coupon debt securities issued by the Italian Treasury with maturities between 18 and 24 months.
	 */
	IT_CTZ("IT-CTZ"),
	

	/**
	 * MIB30 Equity Securities.
	 */
	IT_MIB30("IT-MIB30"),
	

	/**
	 * Debt securities issued and marketed by the Republic of Italy outside the Italian market, traded as Eurobonds.
	 */
	IT_REP("IT-REP"),
	

	/**
	 * Japanese Yen (JPY) Cash.
	 */
	JP_CASH("JP-CASH"),
	

	/**
	 * Corporate bonds including straight bonds.
	 */
	JP_CORPORATE("JP-CORPORATE"),
	

	/**
	 * Commercial Paper.
	 */
	JP_CP("JP-CP"),
	

	/**
	 * Equity securities issued by a Japanese company, each share representing the minimum unit of participation of a partner in the stock capital of the company.
	 */
	JP_EQUITY("JP-EQUITY"),
	

	/**
	 * Yen-denominated foreign bonds.
	 */
	JP_EUROBOND("JP-EUROBOND"),
	

	/**
	 * Japanese Government Bonds.
	 */
	JP_JGB("JP-JGB"),
	

	/**
	 * Korean Treasury Bonds.
	 */
	KR_BOND("KR-BOND"),
	

	/**
	 * Korean Won (KRW) Cash.
	 */
	KR_CASH("KR-CASH"),
	

	/**
	 * Non Korean Won denominated Export-Import Bank of Korea bonds.
	 */
	KR_EXIM("KR-EXIM"),
	

	/**
	 * Korean Development Insurance Corporation Bonds (Korean Won denominated).
	 */
	KR_KDICKRW("KR-KDICKRW"),
	

	/**
	 * Non-Korean Won denominated Korea Development Bank bonds (KDBs).
	 */
	KR_KDR("KR-KDR"),
	

	/**
	 * KEPCO bonds.
	 */
	KR_KEPCO("KR-KEPCO"),
	

	/**
	 * Monetary Stabilisation Bonds.
	 */
	KR_MSB("KR-MSB"),
	

	/**
	 * Non Korean Won denominated Korea National Housing Corporation bonds (KNHCs).
	 */
	KR_NHC("KR-NHC"),
	

	/**
	 * Non-Korean Won denominated Republic of Korea bonds (ROKs).
	 */
	KR_ROK("KR-ROK"),
	

	/**
	 * AEX Equity Securities.
	 */
	NL_AEX("NL-AEX"),
	

	/**
	 * Dutch Treasury Certificates.
	 */
	NL_BILL("NL-BILL"),
	

	/**
	 * Dutch State Loans.
	 */
	NL_BOND("NL-BOND"),
	

	/**
	 * Norwegian Government Bonds.
	 */
	NO_BOND("NO-BOND"),
	

	/**
	 * Norwegian Krone (NOK) Cash.
	 */
	NO_CASH("NO-CASH"),
	

	/**
	 * OBX Equity Securities.
	 */
	NO_OBX("NO-OBX"),
	

	/**
	 * Norwegian T-Bills.
	 */
	NO_TBILL("NO-TBILL"),
	

	/**
	 * New Zealand Government Bonds.
	 */
	NZ_BOND("NZ-BOND"),
	

	/**
	 * New Zealand Dollar (NZD) Cash.
	 */
	NZ_CASH("NZ-CASH"),
	

	/**
	 * New Zealand Government Treasury Bills.
	 */
	NZ_TBILL("NZ-TBILL"),
	

	/**
	 * Swedish Krona (SEK) Cash.
	 */
	SE_CASH("SE-CASH"),
	

	/**
	 * Swedish Government Bonds (SGB).
	 */
	SE_GOVT("SE-GOVT"),
	

	/**
	 * Swedish Index Linked Government bonds.
	 */
	SE_ILGOVT("SE-ILGOVT"),
	

	/**
	 * Swedish Mortgage Bonds.
	 */
	SE_MORT("SE-MORT"),
	

	/**
	 * OMX Equity Securities.
	 */
	SE_OMX("SE-OMX"),
	

	/**
	 * Swedish Treasury Bills (STB).
	 */
	SE_TBILL("SE-TBILL"),
	

	/**
	 * Singapore Government (SGS) Bonds.
	 */
	SG_BOND("SG-BOND"),
	

	/**
	 * Singapore Dollar (SGD) Cash.
	 */
	SG_CASH("SG-CASH"),
	

	/**
	 * Singapore Government T-Bills (T-Bills).
	 */
	SG_TBILL("SG-TBILL"),
	

	/**
	 * Inter-American Development Bank Bonds.
	 */
	SU_IADB("SU-IADB"),
	

	/**
	 * International Bank for Reconstruction and Development (World Bank) Discount Notes.
	 */
	SU_IBRDDN("SU-IBRDDN"),
	

	/**
	 * International Bank for Reconstruction and Development (World Bank or IBRD) Global Benchmark Bonds.
	 */
	SU_IBRDGB("SU-IBRDGB"),
	

	/**
	 * Adjustable Rate Mortgage (ARM) Bonds.
	 */
	US_ARM("US-ARM"),
	

	/**
	 * United States of America Dollar (USD) Cash.
	 */
	US_CASH("US-CASH"),
	

	/**
	 * REMICs, CMOs and other derivative structures.
	 */
	US_DERIV("US-DERIV"),
	

	/**
	 * Dow Jones Industrial Average Equity Securities.
	 */
	US_DOW("US-DOW"),
	

	/**
	 * Dow Jones Composite Average Equity Securities.
	 */
	US_DOW_COMP("US-DOW-COMP"),
	

	/**
	 * Dow Jones Transportation	Average Equity Securities.
	 */
	US_DOW_TRAN("US-DOW-TRAN"),
	

	/**
	 * Dow Jones Utilities Average Equity Securities.
	 */
	US_DOW_UTIL("US-DOW-UTIL"),
	

	/**
	 * Federal Agricultural Mortgage Corp (Farmer Mac) Bonds.
	 */
	US_FAMC("US-FAMC"),
	

	/**
	 * Farm Credit System (FCS) Bonds.
	 */
	US_FCS("US-FCS"),
	

	/**
	 * Farm Credit System Financial Assistance Corporation (FCSFAC) Bonds.
	 */
	US_FCSFAC("US-FCSFAC"),
	

	/**
	 * Callable Agency Debt – Federal Home Loan Bank (FHLB).
	 */
	US_FHLB("US-FHLB"),
	

	/**
	 * Non-Callable Federal Home Loan Bank Debt.
	 */
	US_FHLBNC("US-FHLBNC"),
	

	/**
	 * Non-Callable Federal Home Loan Bank Discount Notes.
	 */
	US_FHLBNCDN("US-FHLBNCDN"),
	

	/**
	 * Callable Agency Debt – the Federal Home Loan Mortgage Corporation (FHLMC or Freddie Mac).
	 */
	US_FHLMC("US-FHLMC"),
	

	/**
	 * Federal Home Loan Mortgage Corporation Certificates – Mortgage Backed Securities.
	 */
	US_FHLMCMBS("US-FHLMCMBS"),
	

	/**
	 * Financing Corp (FICO) Bonds.
	 */
	US_FICO("US-FICO"),
	

	/**
	 * Callable Agency Debt – Federal National Mortgage Association (FNMA or Fannie Mae).
	 */
	US_FNMA("US-FNMA"),
	

	/**
	 * Federal National Mortgage Association Certificates – Mortgage Backed Securities.
	 */
	US_FNMAMBS("US-FNMAMBS"),
	

	/**
	 * Callable Agency Debt – Government National Mortgage Association (GNMA).
	 */
	US_GNMA("US-GNMA"),
	

	/**
	 * Government National Mortgage Association Certificates – Mortgage Backed Securities (GNMA or Ginnie Mae)
	 */
	US_GNMAMBS("US-GNMAMBS"),
	

	/**
	 * Lehman Brothers Credit Bond Index Debt Securities.
	 */
	US_LEHM_BOND("US-LEHM-BOND"),
	

	/**
	 * NASDAQ-100 Index Equity Securities.
	 */
	US_NAS_100("US-NAS-100"),
	

	/**
	 * NASDAQ Composite Index Equity Securities.
	 */
	US_NAS_COMP("US-NAS-COMP"),
	

	/**
	 * Non-Callable Agency Debt – Various Issuers.
	 */
	US_NCAD("US-NCAD"),
	

	/**
	 * Non-Callable Agency Discount Notes – Various Issuers.
	 */
	US_NCADN("US-NCADN"),
	

	/**
	 * NYSE Composite Index Equity Securities.
	 */
	US_NYSE_COMP("US-NYSE-COMP"),
	

	/**
	 * Resolution Funding Corp (REFCorp) Bonds.
	 */
	US_REFCORP("US-REFCORP"),
	

	/**
	 * Student Loan Marketing Association (Sallie Mae) Bonds.
	 */
	US_SLMA("US-SLMA"),
	

	/**
	 * US Treasury Strips.
	 */
	US_STRIP("US-STRIP"),
	

	/**
	 * Standard &amp; Poor’s 100 Index Equity Securities.
	 */
	US_S_P100("US-S&P100"),
	

	/**
	 * Standard &amp; Poor’s Midcap 400 Equity Securities. corporations that are included within the Standard And Poor&#39;s Midcap 400 Index published by Standard And Poor&#39;s, a division of The McGraw-Hill Companies, Inc.
	 */
	US_S_P400("US-S&P400"),
	

	/**
	 * Standard &amp; Poor’s 500 Index Equity Securities.
	 */
	US_S_P500("US-S&P500"),
	

	/**
	 * Standard &amp; Poor’s Smallcap 600 Index Equity Securities.
	 */
	US_S_P600("US-S&P600"),
	

	/**
	 * US Treasury Bills.
	 */
	US_TBILL("US-TBILL"),
	

	/**
	 * US Treasury Bonds.
	 */
	US_TBOND("US-TBOND"),
	

	/**
	 * US Treasury Inflation Protected Issues (TIPS).
	 */
	US_TIPS("US-TIPS"),
	

	/**
	 * US Treasury Notes.
	 */
	US_TNOTE("US-TNOTE"),
	

	/**
	 * Tennessee Valley Authority (TVA) Bonds.
	 */
	US_TVA("US-TVA")
	;

	private final String displayName;
	
	CollateralAssetDefinitionsEnum() {
		this.displayName = null;
	}

	CollateralAssetDefinitionsEnum(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
