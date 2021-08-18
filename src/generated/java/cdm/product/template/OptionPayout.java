package cdm.product.template;

import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.meta.OptionPayoutMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 *  The option payout specification terms. The associated globalKey denotes the ability to associate a hash value to the respective OptionPayout instantiation for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version ${project.version}
 */
@RosettaClass

public interface OptionPayout extends PayoutBase, GlobalKey {
	OptionPayout build();
	OptionPayout.OptionPayoutBuilder toBuilder();
	
	/**
	 */
	BuyerSeller getBuyerSeller();
	/**
	 * The terms for exercising the option, which include the option style (e.g. American style option), the exercise procedure (e.g. manual exercise) and the settlement terms (e.g. physical vs. cash).
	 */
	OptionExercise getExerciseTerms();
	/**
	 * The option feature, such as quanto, Asian, barrier, knock.
	 */
	OptionFeature getFeature();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The type of option transaction. From a usage standpoint, put/call is the default option type, while payer/receiver indicator is used for options on index credit default swaps, consistently with the industry practice. Straddle is used for the case of straddle strategy, that combine a call and a put with the same strike.
	 */
	OptionTypeEnum getOptionType();
	/**
	 * The product underlying the option, which can be of any type including ContractualProduct or Security.
	 */
	Product getUnderlier();
	final static OptionPayoutMeta metaData = new OptionPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends OptionPayout> metaData() {
		return metaData;
	} 
			
	static OptionPayout.OptionPayoutBuilder builder() {
		return new OptionPayout.OptionPayoutBuilderImpl();
	}
	
	default Class<? extends OptionPayout> getType() {
		return OptionPayout.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.common.settlement.PayoutBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
		
		processRosetta(path.newSubPath("buyerSeller"), processor, BuyerSeller.class, getBuyerSeller());
		processRosetta(path.newSubPath("exerciseTerms"), processor, OptionExercise.class, getExerciseTerms());
		processRosetta(path.newSubPath("feature"), processor, OptionFeature.class, getFeature());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("underlier"), processor, Product.class, getUnderlier());
	}
	
	
	interface OptionPayoutBuilder extends OptionPayout, PayoutBase.PayoutBaseBuilder, RosettaModelObjectBuilder {
		BuyerSeller.BuyerSellerBuilder getOrCreateBuyerSeller();
		BuyerSeller.BuyerSellerBuilder getBuyerSeller();
		OptionExercise.OptionExerciseBuilder getOrCreateExerciseTerms();
		OptionExercise.OptionExerciseBuilder getExerciseTerms();
		OptionFeature.OptionFeatureBuilder getOrCreateFeature();
		OptionFeature.OptionFeatureBuilder getFeature();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Product.ProductBuilder getOrCreateUnderlier();
		Product.ProductBuilder getUnderlier();
		OptionPayout.OptionPayoutBuilder setBuyerSeller(BuyerSeller buyerSeller);
		OptionPayout.OptionPayoutBuilder setExerciseTerms(OptionExercise exerciseTerms);
		OptionPayout.OptionPayoutBuilder setFeature(OptionFeature feature);
		OptionPayout.OptionPayoutBuilder setMeta(MetaFields meta);
		OptionPayout.OptionPayoutBuilder setOptionType(OptionTypeEnum optionType);
		OptionPayout.OptionPayoutBuilder setUnderlier(Product underlier);
		OptionPayout.OptionPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		OptionPayout.OptionPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity);
		OptionPayout.OptionPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PayoutBase.PayoutBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
			
			processRosetta(path.newSubPath("buyerSeller"), processor, BuyerSeller.BuyerSellerBuilder.class, getBuyerSeller());
			processRosetta(path.newSubPath("exerciseTerms"), processor, OptionExercise.OptionExerciseBuilder.class, getExerciseTerms());
			processRosetta(path.newSubPath("feature"), processor, OptionFeature.OptionFeatureBuilder.class, getFeature());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("underlier"), processor, Product.ProductBuilder.class, getUnderlier());
		}
		
	}
	
	//OptionPayout.OptionPayoutImpl
	class OptionPayoutImpl extends PayoutBase.PayoutBaseImpl implements OptionPayout {
		private final BuyerSeller buyerSeller;
		private final OptionExercise exerciseTerms;
		private final OptionFeature feature;
		private final MetaFields meta;
		private final OptionTypeEnum optionType;
		private final Product underlier;
		
		protected OptionPayoutImpl(OptionPayout.OptionPayoutBuilder builder) {
			super(builder);
			this.buyerSeller = ofNullable(builder.getBuyerSeller()).map(f->f.build()).orElse(null);
			this.exerciseTerms = ofNullable(builder.getExerciseTerms()).map(f->f.build()).orElse(null);
			this.feature = ofNullable(builder.getFeature()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.optionType = builder.getOptionType();
			this.underlier = ofNullable(builder.getUnderlier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BuyerSeller getBuyerSeller() {
			return buyerSeller;
		}
		
		@Override
		public OptionExercise getExerciseTerms() {
			return exerciseTerms;
		}
		
		@Override
		public OptionFeature getFeature() {
			return feature;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public OptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		public Product getUnderlier() {
			return underlier;
		}
		
		@Override
		public OptionPayout build() {
			return this;
		}
		
		@Override
		public OptionPayout.OptionPayoutBuilder toBuilder() {
			OptionPayout.OptionPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionPayout.OptionPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerSeller()).ifPresent(builder::setBuyerSeller);
			ofNullable(getExerciseTerms()).ifPresent(builder::setExerciseTerms);
			ofNullable(getFeature()).ifPresent(builder::setFeature);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getUnderlier()).ifPresent(builder::setUnderlier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionPayout _that = getType().cast(o);
		
			if (!Objects.equals(buyerSeller, _that.getBuyerSeller())) return false;
			if (!Objects.equals(exerciseTerms, _that.getExerciseTerms())) return false;
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSeller != null ? buyerSeller.hashCode() : 0);
			_result = 31 * _result + (exerciseTerms != null ? exerciseTerms.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionPayout {" +
				"buyerSeller=" + this.buyerSeller + ", " +
				"exerciseTerms=" + this.exerciseTerms + ", " +
				"feature=" + this.feature + ", " +
				"meta=" + this.meta + ", " +
				"optionType=" + this.optionType + ", " +
				"underlier=" + this.underlier +
			'}' + " " + super.toString();
		}
	}
	
	//OptionPayout.OptionPayoutBuilderImpl
	class OptionPayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl  implements OptionPayout.OptionPayoutBuilder, GlobalKeyBuilder {
	
		protected BuyerSeller.BuyerSellerBuilder buyerSeller;
		protected OptionExercise.OptionExerciseBuilder exerciseTerms;
		protected OptionFeature.OptionFeatureBuilder feature;
		protected MetaFields.MetaFieldsBuilder meta;
		protected OptionTypeEnum optionType;
		protected Product.ProductBuilder underlier;
	
		public OptionPayoutBuilderImpl() {
		}
	
		@Override
		public BuyerSeller.BuyerSellerBuilder getBuyerSeller() {
			return buyerSeller;
		}
		
		@Override
		public BuyerSeller.BuyerSellerBuilder getOrCreateBuyerSeller() {
			BuyerSeller.BuyerSellerBuilder result;
			if (buyerSeller!=null) {
				result = buyerSeller;
			}
			else {
				result = buyerSeller = BuyerSeller.builder();
			}
			
			return result;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder getExerciseTerms() {
			return exerciseTerms;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder getOrCreateExerciseTerms() {
			OptionExercise.OptionExerciseBuilder result;
			if (exerciseTerms!=null) {
				result = exerciseTerms;
			}
			else {
				result = exerciseTerms = OptionExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public OptionFeature.OptionFeatureBuilder getFeature() {
			return feature;
		}
		
		@Override
		public OptionFeature.OptionFeatureBuilder getOrCreateFeature() {
			OptionFeature.OptionFeatureBuilder result;
			if (feature!=null) {
				result = feature;
			}
			else {
				result = feature = OptionFeature.builder();
			}
			
			return result;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public OptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		public Product.ProductBuilder getUnderlier() {
			return underlier;
		}
		
		@Override
		public Product.ProductBuilder getOrCreateUnderlier() {
			Product.ProductBuilder result;
			if (underlier!=null) {
				result = underlier;
			}
			else {
				result = underlier = Product.builder();
			}
			
			return result;
		}
		
	
		@Override
		public OptionPayout.OptionPayoutBuilder setBuyerSeller(BuyerSeller buyerSeller) {
			this.buyerSeller = buyerSeller==null?null:buyerSeller.toBuilder();
			return this;
		}
		@Override
		public OptionPayout.OptionPayoutBuilder setExerciseTerms(OptionExercise exerciseTerms) {
			this.exerciseTerms = exerciseTerms==null?null:exerciseTerms.toBuilder();
			return this;
		}
		@Override
		public OptionPayout.OptionPayoutBuilder setFeature(OptionFeature feature) {
			this.feature = feature==null?null:feature.toBuilder();
			return this;
		}
		@Override
		public OptionPayout.OptionPayoutBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public OptionPayout.OptionPayoutBuilder setOptionType(OptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		public OptionPayout.OptionPayoutBuilder setUnderlier(Product underlier) {
			this.underlier = underlier==null?null:underlier.toBuilder();
			return this;
		}
		@Override
		public OptionPayout.OptionPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public OptionPayout.OptionPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity) {
			this.payoutQuantity = payoutQuantity==null?null:payoutQuantity.toBuilder();
			return this;
		}
		@Override
		public OptionPayout.OptionPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public OptionPayout build() {
			return new OptionPayout.OptionPayoutImpl(this);
		}
		
		@Override
		public OptionPayout.OptionPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionPayout.OptionPayoutBuilder prune() {
			super.prune();
			if (buyerSeller!=null && !buyerSeller.prune().hasData()) buyerSeller = null;
			if (exerciseTerms!=null && !exerciseTerms.prune().hasData()) exerciseTerms = null;
			if (feature!=null && !feature.prune().hasData()) feature = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (underlier!=null && !underlier.prune().hasData()) underlier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerSeller()!=null && getBuyerSeller().hasData()) return true;
			if (getExerciseTerms()!=null && getExerciseTerms().hasData()) return true;
			if (getFeature()!=null && getFeature().hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getUnderlier()!=null && getUnderlier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionPayout.OptionPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OptionPayout.OptionPayoutBuilder o = (OptionPayout.OptionPayoutBuilder) other;
			
			merger.mergeRosetta(getBuyerSeller(), o.getBuyerSeller(), this::setBuyerSeller);
			merger.mergeRosetta(getExerciseTerms(), o.getExerciseTerms(), this::setExerciseTerms);
			merger.mergeRosetta(getFeature(), o.getFeature(), this::setFeature);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getUnderlier(), o.getUnderlier(), this::setUnderlier);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionPayout _that = getType().cast(o);
		
			if (!Objects.equals(buyerSeller, _that.getBuyerSeller())) return false;
			if (!Objects.equals(exerciseTerms, _that.getExerciseTerms())) return false;
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSeller != null ? buyerSeller.hashCode() : 0);
			_result = 31 * _result + (exerciseTerms != null ? exerciseTerms.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionPayoutBuilder {" +
				"buyerSeller=" + this.buyerSeller + ", " +
				"exerciseTerms=" + this.exerciseTerms + ", " +
				"feature=" + this.feature + ", " +
				"meta=" + this.meta + ", " +
				"optionType=" + this.optionType + ", " +
				"underlier=" + this.underlier +
			'}' + " " + super.toString();
		}
	}
}
