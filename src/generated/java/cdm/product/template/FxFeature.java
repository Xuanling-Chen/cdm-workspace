package cdm.product.template;

import cdm.product.template.meta.FxFeatureMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining FX Features.
 * @version ${project.version}
 */
@RosettaClass

public interface FxFeature extends RosettaModelObject {
	FxFeature build();
	FxFeature.FxFeatureBuilder toBuilder();
	
	/**
	 * If &#39;Composite&#39; is specified as the Settlement Type in the relevant Transaction Supplement, an amount in the Settlement Currency, determined by the Calculation Agent as being equal to the number of Options exercised or deemed exercised, multiplied by: (Settlement Price – Strike Price) / (Strike Price – Settlement Price) x Multiplier provided that if the above is equal to a negative amount the Option Cash Settlement Amount shall be deemed to be zero.
	 */
	Composite getComposite();
	/**
	 * If &#39;Cross-Currency&#39; is specified as the Settlement Type in the relevant Transaction Supplement, an amount in the Settlement Currency, determined by the Calculation Agent as being equal to the number of Options exercised or deemed exercised, multiplied by: (Settlement Price – Strike Price) / (Strike Price – Settlement Price) x Multiplier x one unit of the Reference Currency converted into an amount in the Settlement Currency using the rate of exchange of the Settlement Currency as quoted on the Reference Price Source on the Valuation Date, provided that if the above is equal to a negative amount the Option Cash Settlement Amount shall be deemed to be zero.
	 */
	Composite getCrossCurrency();
	/**
	 * If &#39;Quanto&#39; is specified as the Settlement Type in the relevant Transaction Supplement, an amount, as determined by the Calculation Agent in accordance with the Section 8.2 of the Equity Definitions.
	 */
	Quanto getQuanto();
	/**
	 * Specifies the reference currency of the trade.
	 */
	FieldWithMetaString getReferenceCurrency();
	final static FxFeatureMeta metaData = new FxFeatureMeta();
	
	@Override
	default RosettaMetaData<? extends FxFeature> metaData() {
		return metaData;
	} 
			
	static FxFeature.FxFeatureBuilder builder() {
		return new FxFeature.FxFeatureBuilderImpl();
	}
	
	default Class<? extends FxFeature> getType() {
		return FxFeature.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("composite"), processor, Composite.class, getComposite());
		processRosetta(path.newSubPath("crossCurrency"), processor, Composite.class, getCrossCurrency());
		processRosetta(path.newSubPath("quanto"), processor, Quanto.class, getQuanto());
		processRosetta(path.newSubPath("referenceCurrency"), processor, FieldWithMetaString.class, getReferenceCurrency(), AttributeMeta.GLOBAL_KEY_FIELD);
	}
	
	
	interface FxFeatureBuilder extends FxFeature, RosettaModelObjectBuilder {
		Composite.CompositeBuilder getOrCreateComposite();
		Composite.CompositeBuilder getComposite();
		Composite.CompositeBuilder getOrCreateCrossCurrency();
		Composite.CompositeBuilder getCrossCurrency();
		Quanto.QuantoBuilder getOrCreateQuanto();
		Quanto.QuantoBuilder getQuanto();
		FieldWithMetaStringBuilder getOrCreateReferenceCurrency();
		FieldWithMetaStringBuilder getReferenceCurrency();
		FxFeature.FxFeatureBuilder setComposite(Composite composite);
		FxFeature.FxFeatureBuilder setCrossCurrency(Composite crossCurrency);
		FxFeature.FxFeatureBuilder setQuanto(Quanto quanto);
		FxFeature.FxFeatureBuilder setReferenceCurrency(FieldWithMetaString referenceCurrency);
		FxFeature.FxFeatureBuilder setReferenceCurrencyValue(String referenceCurrency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("composite"), processor, Composite.CompositeBuilder.class, getComposite());
			processRosetta(path.newSubPath("crossCurrency"), processor, Composite.CompositeBuilder.class, getCrossCurrency());
			processRosetta(path.newSubPath("quanto"), processor, Quanto.QuantoBuilder.class, getQuanto());
			processRosetta(path.newSubPath("referenceCurrency"), processor, FieldWithMetaStringBuilder.class, getReferenceCurrency(), AttributeMeta.GLOBAL_KEY_FIELD);
		}
		
	}
	
	//FxFeature.FxFeatureImpl
	class FxFeatureImpl implements FxFeature {
		private final Composite composite;
		private final Composite crossCurrency;
		private final Quanto quanto;
		private final FieldWithMetaString referenceCurrency;
		
		protected FxFeatureImpl(FxFeature.FxFeatureBuilder builder) {
			this.composite = ofNullable(builder.getComposite()).map(f->f.build()).orElse(null);
			this.crossCurrency = ofNullable(builder.getCrossCurrency()).map(f->f.build()).orElse(null);
			this.quanto = ofNullable(builder.getQuanto()).map(f->f.build()).orElse(null);
			this.referenceCurrency = ofNullable(builder.getReferenceCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Composite getComposite() {
			return composite;
		}
		
		@Override
		public Composite getCrossCurrency() {
			return crossCurrency;
		}
		
		@Override
		public Quanto getQuanto() {
			return quanto;
		}
		
		@Override
		public FieldWithMetaString getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		public FxFeature build() {
			return this;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder toBuilder() {
			FxFeature.FxFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFeature.FxFeatureBuilder builder) {
			ofNullable(getComposite()).ifPresent(builder::setComposite);
			ofNullable(getCrossCurrency()).ifPresent(builder::setCrossCurrency);
			ofNullable(getQuanto()).ifPresent(builder::setQuanto);
			ofNullable(getReferenceCurrency()).ifPresent(builder::setReferenceCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFeature _that = getType().cast(o);
		
			if (!Objects.equals(composite, _that.getComposite())) return false;
			if (!Objects.equals(crossCurrency, _that.getCrossCurrency())) return false;
			if (!Objects.equals(quanto, _that.getQuanto())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (composite != null ? composite.hashCode() : 0);
			_result = 31 * _result + (crossCurrency != null ? crossCurrency.hashCode() : 0);
			_result = 31 * _result + (quanto != null ? quanto.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFeature {" +
				"composite=" + this.composite + ", " +
				"crossCurrency=" + this.crossCurrency + ", " +
				"quanto=" + this.quanto + ", " +
				"referenceCurrency=" + this.referenceCurrency +
			'}';
		}
	}
	
	//FxFeature.FxFeatureBuilderImpl
	class FxFeatureBuilderImpl implements FxFeature.FxFeatureBuilder {
	
		protected Composite.CompositeBuilder composite;
		protected Composite.CompositeBuilder crossCurrency;
		protected Quanto.QuantoBuilder quanto;
		protected FieldWithMetaStringBuilder referenceCurrency;
	
		public FxFeatureBuilderImpl() {
		}
	
		@Override
		public Composite.CompositeBuilder getComposite() {
			return composite;
		}
		
		@Override
		public Composite.CompositeBuilder getOrCreateComposite() {
			Composite.CompositeBuilder result;
			if (composite!=null) {
				result = composite;
			}
			else {
				result = composite = Composite.builder();
			}
			
			return result;
		}
		
		@Override
		public Composite.CompositeBuilder getCrossCurrency() {
			return crossCurrency;
		}
		
		@Override
		public Composite.CompositeBuilder getOrCreateCrossCurrency() {
			Composite.CompositeBuilder result;
			if (crossCurrency!=null) {
				result = crossCurrency;
			}
			else {
				result = crossCurrency = Composite.builder();
			}
			
			return result;
		}
		
		@Override
		public Quanto.QuantoBuilder getQuanto() {
			return quanto;
		}
		
		@Override
		public Quanto.QuantoBuilder getOrCreateQuanto() {
			Quanto.QuantoBuilder result;
			if (quanto!=null) {
				result = quanto;
			}
			else {
				result = quanto = Quanto.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateReferenceCurrency() {
			FieldWithMetaStringBuilder result;
			if (referenceCurrency!=null) {
				result = referenceCurrency;
			}
			else {
				result = referenceCurrency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FxFeature.FxFeatureBuilder setComposite(Composite composite) {
			this.composite = composite==null?null:composite.toBuilder();
			return this;
		}
		@Override
		public FxFeature.FxFeatureBuilder setCrossCurrency(Composite crossCurrency) {
			this.crossCurrency = crossCurrency==null?null:crossCurrency.toBuilder();
			return this;
		}
		@Override
		public FxFeature.FxFeatureBuilder setQuanto(Quanto quanto) {
			this.quanto = quanto==null?null:quanto.toBuilder();
			return this;
		}
		@Override
		public FxFeature.FxFeatureBuilder setReferenceCurrency(FieldWithMetaString referenceCurrency) {
			this.referenceCurrency = referenceCurrency==null?null:referenceCurrency.toBuilder();
			return this;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder setReferenceCurrencyValue(String referenceCurrency) {
			this.getOrCreateReferenceCurrency().setValue(referenceCurrency);
			return this;
		}
		
		@Override
		public FxFeature build() {
			return new FxFeature.FxFeatureImpl(this);
		}
		
		@Override
		public FxFeature.FxFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFeature.FxFeatureBuilder prune() {
			if (composite!=null && !composite.prune().hasData()) composite = null;
			if (crossCurrency!=null && !crossCurrency.prune().hasData()) crossCurrency = null;
			if (quanto!=null && !quanto.prune().hasData()) quanto = null;
			if (referenceCurrency!=null && !referenceCurrency.prune().hasData()) referenceCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getComposite()!=null && getComposite().hasData()) return true;
			if (getCrossCurrency()!=null && getCrossCurrency().hasData()) return true;
			if (getQuanto()!=null && getQuanto().hasData()) return true;
			if (getReferenceCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFeature.FxFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFeature.FxFeatureBuilder o = (FxFeature.FxFeatureBuilder) other;
			
			merger.mergeRosetta(getComposite(), o.getComposite(), this::setComposite);
			merger.mergeRosetta(getCrossCurrency(), o.getCrossCurrency(), this::setCrossCurrency);
			merger.mergeRosetta(getQuanto(), o.getQuanto(), this::setQuanto);
			merger.mergeRosetta(getReferenceCurrency(), o.getReferenceCurrency(), this::setReferenceCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFeature _that = getType().cast(o);
		
			if (!Objects.equals(composite, _that.getComposite())) return false;
			if (!Objects.equals(crossCurrency, _that.getCrossCurrency())) return false;
			if (!Objects.equals(quanto, _that.getQuanto())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (composite != null ? composite.hashCode() : 0);
			_result = 31 * _result + (crossCurrency != null ? crossCurrency.hashCode() : 0);
			_result = 31 * _result + (quanto != null ? quanto.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFeatureBuilder {" +
				"composite=" + this.composite + ", " +
				"crossCurrency=" + this.crossCurrency + ", " +
				"quanto=" + this.quanto + ", " +
				"referenceCurrency=" + this.referenceCurrency +
			'}';
		}
	}
}
