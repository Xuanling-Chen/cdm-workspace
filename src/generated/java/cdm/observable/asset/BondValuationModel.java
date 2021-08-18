package cdm.observable.asset;

import cdm.observable.asset.meta.BondValuationModelMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 *  Bond valuation model for the security leg in a securities financing transaction, closely modelled onto the BondCollateral.model in FpML.
 * @version ${project.version}
 */
@RosettaClass

public interface BondValuationModel extends RosettaModelObject {
	BondValuationModel build();
	BondValuationModel.BondValuationModelBuilder toBuilder();
	
	/**
	 * Accruals amount for the bond in the security leg
	 */
	Money getAccrualsAmount();
	/**
	 * Price and yield model for valuing a bond security leg.
	 */
	BondPriceAndYieldModel getBondPriceAndYieldModel();
	/**
	 * The quantity of the underlier expressed as a nominal amount.
	 */
	Money getNominalAmount();
	final static BondValuationModelMeta metaData = new BondValuationModelMeta();
	
	@Override
	default RosettaMetaData<? extends BondValuationModel> metaData() {
		return metaData;
	} 
			
	static BondValuationModel.BondValuationModelBuilder builder() {
		return new BondValuationModel.BondValuationModelBuilderImpl();
	}
	
	default Class<? extends BondValuationModel> getType() {
		return BondValuationModel.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("accrualsAmount"), processor, Money.class, getAccrualsAmount());
		processRosetta(path.newSubPath("bondPriceAndYieldModel"), processor, BondPriceAndYieldModel.class, getBondPriceAndYieldModel());
		processRosetta(path.newSubPath("nominalAmount"), processor, Money.class, getNominalAmount());
	}
	
	
	interface BondValuationModelBuilder extends BondValuationModel, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateAccrualsAmount();
		Money.MoneyBuilder getAccrualsAmount();
		BondPriceAndYieldModel.BondPriceAndYieldModelBuilder getOrCreateBondPriceAndYieldModel();
		BondPriceAndYieldModel.BondPriceAndYieldModelBuilder getBondPriceAndYieldModel();
		Money.MoneyBuilder getOrCreateNominalAmount();
		Money.MoneyBuilder getNominalAmount();
		BondValuationModel.BondValuationModelBuilder setAccrualsAmount(Money accrualsAmount);
		BondValuationModel.BondValuationModelBuilder setBondPriceAndYieldModel(BondPriceAndYieldModel bondPriceAndYieldModel);
		BondValuationModel.BondValuationModelBuilder setNominalAmount(Money nominalAmount);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("accrualsAmount"), processor, Money.MoneyBuilder.class, getAccrualsAmount());
			processRosetta(path.newSubPath("bondPriceAndYieldModel"), processor, BondPriceAndYieldModel.BondPriceAndYieldModelBuilder.class, getBondPriceAndYieldModel());
			processRosetta(path.newSubPath("nominalAmount"), processor, Money.MoneyBuilder.class, getNominalAmount());
		}
		
	}
	
	//BondValuationModel.BondValuationModelImpl
	class BondValuationModelImpl implements BondValuationModel {
		private final Money accrualsAmount;
		private final BondPriceAndYieldModel bondPriceAndYieldModel;
		private final Money nominalAmount;
		
		protected BondValuationModelImpl(BondValuationModel.BondValuationModelBuilder builder) {
			this.accrualsAmount = ofNullable(builder.getAccrualsAmount()).map(f->f.build()).orElse(null);
			this.bondPriceAndYieldModel = ofNullable(builder.getBondPriceAndYieldModel()).map(f->f.build()).orElse(null);
			this.nominalAmount = ofNullable(builder.getNominalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Money getAccrualsAmount() {
			return accrualsAmount;
		}
		
		@Override
		public BondPriceAndYieldModel getBondPriceAndYieldModel() {
			return bondPriceAndYieldModel;
		}
		
		@Override
		public Money getNominalAmount() {
			return nominalAmount;
		}
		
		@Override
		public BondValuationModel build() {
			return this;
		}
		
		@Override
		public BondValuationModel.BondValuationModelBuilder toBuilder() {
			BondValuationModel.BondValuationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BondValuationModel.BondValuationModelBuilder builder) {
			ofNullable(getAccrualsAmount()).ifPresent(builder::setAccrualsAmount);
			ofNullable(getBondPriceAndYieldModel()).ifPresent(builder::setBondPriceAndYieldModel);
			ofNullable(getNominalAmount()).ifPresent(builder::setNominalAmount);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondValuationModel _that = getType().cast(o);
		
			if (!Objects.equals(accrualsAmount, _that.getAccrualsAmount())) return false;
			if (!Objects.equals(bondPriceAndYieldModel, _that.getBondPriceAndYieldModel())) return false;
			if (!Objects.equals(nominalAmount, _that.getNominalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accrualsAmount != null ? accrualsAmount.hashCode() : 0);
			_result = 31 * _result + (bondPriceAndYieldModel != null ? bondPriceAndYieldModel.hashCode() : 0);
			_result = 31 * _result + (nominalAmount != null ? nominalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondValuationModel {" +
				"accrualsAmount=" + this.accrualsAmount + ", " +
				"bondPriceAndYieldModel=" + this.bondPriceAndYieldModel + ", " +
				"nominalAmount=" + this.nominalAmount +
			'}';
		}
	}
	
	//BondValuationModel.BondValuationModelBuilderImpl
	class BondValuationModelBuilderImpl implements BondValuationModel.BondValuationModelBuilder {
	
		protected Money.MoneyBuilder accrualsAmount;
		protected BondPriceAndYieldModel.BondPriceAndYieldModelBuilder bondPriceAndYieldModel;
		protected Money.MoneyBuilder nominalAmount;
	
		public BondValuationModelBuilderImpl() {
		}
	
		@Override
		public Money.MoneyBuilder getAccrualsAmount() {
			return accrualsAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAccrualsAmount() {
			Money.MoneyBuilder result;
			if (accrualsAmount!=null) {
				result = accrualsAmount;
			}
			else {
				result = accrualsAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder getBondPriceAndYieldModel() {
			return bondPriceAndYieldModel;
		}
		
		@Override
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder getOrCreateBondPriceAndYieldModel() {
			BondPriceAndYieldModel.BondPriceAndYieldModelBuilder result;
			if (bondPriceAndYieldModel!=null) {
				result = bondPriceAndYieldModel;
			}
			else {
				result = bondPriceAndYieldModel = BondPriceAndYieldModel.builder();
			}
			
			return result;
		}
		
		@Override
		public Money.MoneyBuilder getNominalAmount() {
			return nominalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateNominalAmount() {
			Money.MoneyBuilder result;
			if (nominalAmount!=null) {
				result = nominalAmount;
			}
			else {
				result = nominalAmount = Money.builder();
			}
			
			return result;
		}
		
	
		@Override
		public BondValuationModel.BondValuationModelBuilder setAccrualsAmount(Money accrualsAmount) {
			this.accrualsAmount = accrualsAmount==null?null:accrualsAmount.toBuilder();
			return this;
		}
		@Override
		public BondValuationModel.BondValuationModelBuilder setBondPriceAndYieldModel(BondPriceAndYieldModel bondPriceAndYieldModel) {
			this.bondPriceAndYieldModel = bondPriceAndYieldModel==null?null:bondPriceAndYieldModel.toBuilder();
			return this;
		}
		@Override
		public BondValuationModel.BondValuationModelBuilder setNominalAmount(Money nominalAmount) {
			this.nominalAmount = nominalAmount==null?null:nominalAmount.toBuilder();
			return this;
		}
		
		@Override
		public BondValuationModel build() {
			return new BondValuationModel.BondValuationModelImpl(this);
		}
		
		@Override
		public BondValuationModel.BondValuationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondValuationModel.BondValuationModelBuilder prune() {
			if (accrualsAmount!=null && !accrualsAmount.prune().hasData()) accrualsAmount = null;
			if (bondPriceAndYieldModel!=null && !bondPriceAndYieldModel.prune().hasData()) bondPriceAndYieldModel = null;
			if (nominalAmount!=null && !nominalAmount.prune().hasData()) nominalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccrualsAmount()!=null && getAccrualsAmount().hasData()) return true;
			if (getBondPriceAndYieldModel()!=null && getBondPriceAndYieldModel().hasData()) return true;
			if (getNominalAmount()!=null && getNominalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondValuationModel.BondValuationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BondValuationModel.BondValuationModelBuilder o = (BondValuationModel.BondValuationModelBuilder) other;
			
			merger.mergeRosetta(getAccrualsAmount(), o.getAccrualsAmount(), this::setAccrualsAmount);
			merger.mergeRosetta(getBondPriceAndYieldModel(), o.getBondPriceAndYieldModel(), this::setBondPriceAndYieldModel);
			merger.mergeRosetta(getNominalAmount(), o.getNominalAmount(), this::setNominalAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondValuationModel _that = getType().cast(o);
		
			if (!Objects.equals(accrualsAmount, _that.getAccrualsAmount())) return false;
			if (!Objects.equals(bondPriceAndYieldModel, _that.getBondPriceAndYieldModel())) return false;
			if (!Objects.equals(nominalAmount, _that.getNominalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accrualsAmount != null ? accrualsAmount.hashCode() : 0);
			_result = 31 * _result + (bondPriceAndYieldModel != null ? bondPriceAndYieldModel.hashCode() : 0);
			_result = 31 * _result + (nominalAmount != null ? nominalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondValuationModelBuilder {" +
				"accrualsAmount=" + this.accrualsAmount + ", " +
				"bondPriceAndYieldModel=" + this.bondPriceAndYieldModel + ", " +
				"nominalAmount=" + this.nominalAmount +
			'}';
		}
	}
}
