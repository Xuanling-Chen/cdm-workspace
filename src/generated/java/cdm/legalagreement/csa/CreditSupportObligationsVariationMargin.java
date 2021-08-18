package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CreditSupportObligationsVariationMarginMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Credit Support Obligations applicable to the Variation Margin Credit Support Annex and which are common among the English, Japanese and New York governing laws. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c): Credit Support Obligations.
 * @version ${project.version}
 */
@RosettaClass

public interface CreditSupportObligationsVariationMargin extends RosettaModelObject {
	CreditSupportObligationsVariationMargin build();
	CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder toBuilder();
	
	/**
	 * The alternative definition for FX haircut percentage that applies to each party (as the pledgor/chargor/obligor) and item of Eligible Collateral unless this item is denominated in a Major Currency or in the Base Currency. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(v)(B): FX Haircut Percentage.
	 */
	String getFxHaircut();
	/**
	 * The parties to which the provisions of Paragraph 11(g) of the ISDA 2016 Credit Support Annex for Variation Margin will apply to. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(iii): Legally Ineligible Credit Support (VM).
	 */
	IneligibleCreditSupport getIneligibleCreditSupport();
	/**
	 * The additional currencies that are specified as Major Currency for the purpose of applying the FX Haircut Percentage. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(v)(B): FX Haircut Percentage.
	 */
	List<? extends FieldWithMetaString> getMajorCurrency();
	final static CreditSupportObligationsVariationMarginMeta metaData = new CreditSupportObligationsVariationMarginMeta();
	
	@Override
	default RosettaMetaData<? extends CreditSupportObligationsVariationMargin> metaData() {
		return metaData;
	} 
			
	static CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder builder() {
		return new CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilderImpl();
	}
	
	default Class<? extends CreditSupportObligationsVariationMargin> getType() {
		return CreditSupportObligationsVariationMargin.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fxHaircut"), String.class, getFxHaircut(), this);
		
		processRosetta(path.newSubPath("ineligibleCreditSupport"), processor, IneligibleCreditSupport.class, getIneligibleCreditSupport());
		processRosetta(path.newSubPath("majorCurrency"), processor, FieldWithMetaString.class, getMajorCurrency());
	}
	
	
	interface CreditSupportObligationsVariationMarginBuilder extends CreditSupportObligationsVariationMargin, RosettaModelObjectBuilder {
		IneligibleCreditSupport.IneligibleCreditSupportBuilder getOrCreateIneligibleCreditSupport();
		IneligibleCreditSupport.IneligibleCreditSupportBuilder getIneligibleCreditSupport();
		FieldWithMetaStringBuilder getOrCreateMajorCurrency(int _index);
		List<? extends FieldWithMetaStringBuilder> getMajorCurrency();
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setFxHaircut(String fxHaircut);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setIneligibleCreditSupport(IneligibleCreditSupport ineligibleCreditSupport);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(FieldWithMetaString majorCurrency);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(FieldWithMetaString majorCurrency, int _idx);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(String majorCurrency);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(String majorCurrency, int _idx);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(List<? extends FieldWithMetaString> majorCurrency);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setMajorCurrency(List<? extends FieldWithMetaString> majorCurrency);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(List<? extends String> majorCurrency);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setMajorCurrencyValue(List<? extends String> majorCurrency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("fxHaircut"), String.class, getFxHaircut(), this);
			
			processRosetta(path.newSubPath("ineligibleCreditSupport"), processor, IneligibleCreditSupport.IneligibleCreditSupportBuilder.class, getIneligibleCreditSupport());
			processRosetta(path.newSubPath("majorCurrency"), processor, FieldWithMetaStringBuilder.class, getMajorCurrency());
		}
		
	}
	
	//CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginImpl
	class CreditSupportObligationsVariationMarginImpl implements CreditSupportObligationsVariationMargin {
		private final String fxHaircut;
		private final IneligibleCreditSupport ineligibleCreditSupport;
		private final List<? extends FieldWithMetaString> majorCurrency;
		
		protected CreditSupportObligationsVariationMarginImpl(CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder builder) {
			this.fxHaircut = builder.getFxHaircut();
			this.ineligibleCreditSupport = ofNullable(builder.getIneligibleCreditSupport()).map(f->f.build()).orElse(null);
			this.majorCurrency = ofNullable(builder.getMajorCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public String getFxHaircut() {
			return fxHaircut;
		}
		
		@Override
		public IneligibleCreditSupport getIneligibleCreditSupport() {
			return ineligibleCreditSupport;
		}
		
		@Override
		public List<? extends FieldWithMetaString> getMajorCurrency() {
			return majorCurrency;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin build() {
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder toBuilder() {
			CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder builder) {
			ofNullable(getFxHaircut()).ifPresent(builder::setFxHaircut);
			ofNullable(getIneligibleCreditSupport()).ifPresent(builder::setIneligibleCreditSupport);
			ofNullable(getMajorCurrency()).ifPresent(builder::setMajorCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportObligationsVariationMargin _that = getType().cast(o);
		
			if (!Objects.equals(fxHaircut, _that.getFxHaircut())) return false;
			if (!Objects.equals(ineligibleCreditSupport, _that.getIneligibleCreditSupport())) return false;
			if (!ListEquals.listEquals(majorCurrency, _that.getMajorCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxHaircut != null ? fxHaircut.hashCode() : 0);
			_result = 31 * _result + (ineligibleCreditSupport != null ? ineligibleCreditSupport.hashCode() : 0);
			_result = 31 * _result + (majorCurrency != null ? majorCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportObligationsVariationMargin {" +
				"fxHaircut=" + this.fxHaircut + ", " +
				"ineligibleCreditSupport=" + this.ineligibleCreditSupport + ", " +
				"majorCurrency=" + this.majorCurrency +
			'}';
		}
	}
	
	//CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilderImpl
	class CreditSupportObligationsVariationMarginBuilderImpl implements CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder {
	
		protected String fxHaircut;
		protected IneligibleCreditSupport.IneligibleCreditSupportBuilder ineligibleCreditSupport;
		protected List<FieldWithMetaStringBuilder> majorCurrency = new ArrayList<>();
	
		public CreditSupportObligationsVariationMarginBuilderImpl() {
		}
	
		@Override
		public String getFxHaircut() {
			return fxHaircut;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder getIneligibleCreditSupport() {
			return ineligibleCreditSupport;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder getOrCreateIneligibleCreditSupport() {
			IneligibleCreditSupport.IneligibleCreditSupportBuilder result;
			if (ineligibleCreditSupport!=null) {
				result = ineligibleCreditSupport;
			}
			else {
				result = ineligibleCreditSupport = IneligibleCreditSupport.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends FieldWithMetaStringBuilder> getMajorCurrency() {
			return majorCurrency;
		}
		
		public FieldWithMetaStringBuilder getOrCreateMajorCurrency(int _index) {
		
			if (majorCurrency==null) {
				this.majorCurrency = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(majorCurrency, _index, () -> {
						FieldWithMetaStringBuilder newMajorCurrency = FieldWithMetaString.builder();
						return newMajorCurrency;
					});
		}
		
	
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setFxHaircut(String fxHaircut) {
			this.fxHaircut = fxHaircut==null?null:fxHaircut;
			return this;
		}
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setIneligibleCreditSupport(IneligibleCreditSupport ineligibleCreditSupport) {
			this.ineligibleCreditSupport = ineligibleCreditSupport==null?null:ineligibleCreditSupport.toBuilder();
			return this;
		}
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(FieldWithMetaString majorCurrency) {
			if (majorCurrency!=null) this.majorCurrency.add(majorCurrency.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(FieldWithMetaString majorCurrency, int _idx) {
			getIndex(this.majorCurrency, _idx, () -> majorCurrency.toBuilder());
			return this;
		}
		
			@Override
			public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(String majorCurrency) {
				this.getOrCreateMajorCurrency(-1).setValue(majorCurrency);
				return this;
			}
			
			@Override
			public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(String majorCurrency, int _idx) {
				this.getOrCreateMajorCurrency(_idx).setValue(majorCurrency);
				return this;
			}
		@Override 
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(List<? extends FieldWithMetaString> majorCurrencys) {
			if (majorCurrencys != null) {
				for (FieldWithMetaString toAdd : majorCurrencys) {
					this.majorCurrency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setMajorCurrency(List<? extends FieldWithMetaString> majorCurrencys) {
			if (majorCurrencys == null)  {
				this.majorCurrency = new ArrayList<>();
			}
			else {
				this.majorCurrency = majorCurrencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(List<? extends String> majorCurrencys) {
			if (majorCurrencys != null) {
				for (String toAdd : majorCurrencys) {
					this.addMajorCurrencyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setMajorCurrencyValue(List<? extends String> majorCurrencys) {
			this.majorCurrency.clear();
			if (majorCurrencys!=null) {
				majorCurrencys.forEach(this::addMajorCurrencyValue);
			}
			return this;
		}
		
		
		@Override
		public CreditSupportObligationsVariationMargin build() {
			return new CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginImpl(this);
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder prune() {
			if (ineligibleCreditSupport!=null && !ineligibleCreditSupport.prune().hasData()) ineligibleCreditSupport = null;
			majorCurrency = majorCurrency.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxHaircut()!=null) return true;
			if (getIneligibleCreditSupport()!=null && getIneligibleCreditSupport().hasData()) return true;
			if (getMajorCurrency()!=null && !getMajorCurrency().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder o = (CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder) other;
			
			merger.mergeRosetta(getIneligibleCreditSupport(), o.getIneligibleCreditSupport(), this::setIneligibleCreditSupport);
			merger.mergeRosetta(getMajorCurrency(), o.getMajorCurrency(), this::getOrCreateMajorCurrency);
			
			merger.mergeBasic(getFxHaircut(), o.getFxHaircut(), this::setFxHaircut);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportObligationsVariationMargin _that = getType().cast(o);
		
			if (!Objects.equals(fxHaircut, _that.getFxHaircut())) return false;
			if (!Objects.equals(ineligibleCreditSupport, _that.getIneligibleCreditSupport())) return false;
			if (!ListEquals.listEquals(majorCurrency, _that.getMajorCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxHaircut != null ? fxHaircut.hashCode() : 0);
			_result = 31 * _result + (ineligibleCreditSupport != null ? ineligibleCreditSupport.hashCode() : 0);
			_result = 31 * _result + (majorCurrency != null ? majorCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportObligationsVariationMarginBuilder {" +
				"fxHaircut=" + this.fxHaircut + ", " +
				"ineligibleCreditSupport=" + this.ineligibleCreditSupport + ", " +
				"majorCurrency=" + this.majorCurrency +
			'}';
		}
	}
}
