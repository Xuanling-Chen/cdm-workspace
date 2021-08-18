package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CollateralValuationTreatmentMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specification of the valuation treatment for the specified collateral.
 * @version ${project.version}
 */
@RosettaClass

public interface CollateralValuationTreatment extends RosettaModelObject {
	CollateralValuationTreatment build();
	CollateralValuationTreatment.CollateralValuationTreatmentBuilder toBuilder();
	
	/**
	 * Percentage value of any additional haircut to be applied to a collateral asset,the percentage value is expressed as the discount haircut to the value of the collateral- as an example a 5% haircut would be expressed as 0.05. 
	 */
	BigDecimal getAdditionalHaircutPercentage();
	/**
	 * FX haircut applied to a specific asset which is agreed between the parties (for example, if pledgor eligible collateral is not denominated in the termination currency or under other specified cases in collateral support documents both for initial margin and variation margin).The percentage value is expressed as the discount haircut to the value of the collateral- as an example an 8% FX haircut would be expressed as 0.08.
	 */
	BigDecimal getFxHaircutPercentage();
	/**
	 * Haircut percentage to be applied to the value of asset and used as a discount factor to the value of the collateral asset,expressed as a percentage in decimal terms. As an example a 0.5% haircut would be represented as a decimal number 0.005
	 */
	BigDecimal getHaircutPercentage();
	/**
	 * Percentage value of transaction needing to be posted as collateral expressed as a valuation. As an example a 104% requirement would be represented as a decimal number 1.04
	 */
	BigDecimal getMarginPercentage();
	final static CollateralValuationTreatmentMeta metaData = new CollateralValuationTreatmentMeta();
	
	@Override
	default RosettaMetaData<? extends CollateralValuationTreatment> metaData() {
		return metaData;
	} 
			
	static CollateralValuationTreatment.CollateralValuationTreatmentBuilder builder() {
		return new CollateralValuationTreatment.CollateralValuationTreatmentBuilderImpl();
	}
	
	default Class<? extends CollateralValuationTreatment> getType() {
		return CollateralValuationTreatment.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("additionalHaircutPercentage"), BigDecimal.class, getAdditionalHaircutPercentage(), this);
		processor.processBasic(path.newSubPath("fxHaircutPercentage"), BigDecimal.class, getFxHaircutPercentage(), this);
		processor.processBasic(path.newSubPath("haircutPercentage"), BigDecimal.class, getHaircutPercentage(), this);
		processor.processBasic(path.newSubPath("marginPercentage"), BigDecimal.class, getMarginPercentage(), this);
		
	}
	
	
	interface CollateralValuationTreatmentBuilder extends CollateralValuationTreatment, RosettaModelObjectBuilder {
		CollateralValuationTreatment.CollateralValuationTreatmentBuilder setAdditionalHaircutPercentage(BigDecimal additionalHaircutPercentage);
		CollateralValuationTreatment.CollateralValuationTreatmentBuilder setFxHaircutPercentage(BigDecimal fxHaircutPercentage);
		CollateralValuationTreatment.CollateralValuationTreatmentBuilder setHaircutPercentage(BigDecimal haircutPercentage);
		CollateralValuationTreatment.CollateralValuationTreatmentBuilder setMarginPercentage(BigDecimal marginPercentage);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("additionalHaircutPercentage"), BigDecimal.class, getAdditionalHaircutPercentage(), this);
			processor.processBasic(path.newSubPath("fxHaircutPercentage"), BigDecimal.class, getFxHaircutPercentage(), this);
			processor.processBasic(path.newSubPath("haircutPercentage"), BigDecimal.class, getHaircutPercentage(), this);
			processor.processBasic(path.newSubPath("marginPercentage"), BigDecimal.class, getMarginPercentage(), this);
			
		}
		
	}
	
	//CollateralValuationTreatment.CollateralValuationTreatmentImpl
	class CollateralValuationTreatmentImpl implements CollateralValuationTreatment {
		private final BigDecimal additionalHaircutPercentage;
		private final BigDecimal fxHaircutPercentage;
		private final BigDecimal haircutPercentage;
		private final BigDecimal marginPercentage;
		
		protected CollateralValuationTreatmentImpl(CollateralValuationTreatment.CollateralValuationTreatmentBuilder builder) {
			this.additionalHaircutPercentage = builder.getAdditionalHaircutPercentage();
			this.fxHaircutPercentage = builder.getFxHaircutPercentage();
			this.haircutPercentage = builder.getHaircutPercentage();
			this.marginPercentage = builder.getMarginPercentage();
		}
		
		@Override
		public BigDecimal getAdditionalHaircutPercentage() {
			return additionalHaircutPercentage;
		}
		
		@Override
		public BigDecimal getFxHaircutPercentage() {
			return fxHaircutPercentage;
		}
		
		@Override
		public BigDecimal getHaircutPercentage() {
			return haircutPercentage;
		}
		
		@Override
		public BigDecimal getMarginPercentage() {
			return marginPercentage;
		}
		
		@Override
		public CollateralValuationTreatment build() {
			return this;
		}
		
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder toBuilder() {
			CollateralValuationTreatment.CollateralValuationTreatmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralValuationTreatment.CollateralValuationTreatmentBuilder builder) {
			ofNullable(getAdditionalHaircutPercentage()).ifPresent(builder::setAdditionalHaircutPercentage);
			ofNullable(getFxHaircutPercentage()).ifPresent(builder::setFxHaircutPercentage);
			ofNullable(getHaircutPercentage()).ifPresent(builder::setHaircutPercentage);
			ofNullable(getMarginPercentage()).ifPresent(builder::setMarginPercentage);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuationTreatment _that = getType().cast(o);
		
			if (!Objects.equals(additionalHaircutPercentage, _that.getAdditionalHaircutPercentage())) return false;
			if (!Objects.equals(fxHaircutPercentage, _that.getFxHaircutPercentage())) return false;
			if (!Objects.equals(haircutPercentage, _that.getHaircutPercentage())) return false;
			if (!Objects.equals(marginPercentage, _that.getMarginPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalHaircutPercentage != null ? additionalHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (fxHaircutPercentage != null ? fxHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (haircutPercentage != null ? haircutPercentage.hashCode() : 0);
			_result = 31 * _result + (marginPercentage != null ? marginPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValuationTreatment {" +
				"additionalHaircutPercentage=" + this.additionalHaircutPercentage + ", " +
				"fxHaircutPercentage=" + this.fxHaircutPercentage + ", " +
				"haircutPercentage=" + this.haircutPercentage + ", " +
				"marginPercentage=" + this.marginPercentage +
			'}';
		}
	}
	
	//CollateralValuationTreatment.CollateralValuationTreatmentBuilderImpl
	class CollateralValuationTreatmentBuilderImpl implements CollateralValuationTreatment.CollateralValuationTreatmentBuilder {
	
		protected BigDecimal additionalHaircutPercentage;
		protected BigDecimal fxHaircutPercentage;
		protected BigDecimal haircutPercentage;
		protected BigDecimal marginPercentage;
	
		public CollateralValuationTreatmentBuilderImpl() {
		}
	
		@Override
		public BigDecimal getAdditionalHaircutPercentage() {
			return additionalHaircutPercentage;
		}
		
		@Override
		public BigDecimal getFxHaircutPercentage() {
			return fxHaircutPercentage;
		}
		
		@Override
		public BigDecimal getHaircutPercentage() {
			return haircutPercentage;
		}
		
		@Override
		public BigDecimal getMarginPercentage() {
			return marginPercentage;
		}
		
	
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder setAdditionalHaircutPercentage(BigDecimal additionalHaircutPercentage) {
			this.additionalHaircutPercentage = additionalHaircutPercentage==null?null:additionalHaircutPercentage;
			return this;
		}
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder setFxHaircutPercentage(BigDecimal fxHaircutPercentage) {
			this.fxHaircutPercentage = fxHaircutPercentage==null?null:fxHaircutPercentage;
			return this;
		}
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder setHaircutPercentage(BigDecimal haircutPercentage) {
			this.haircutPercentage = haircutPercentage==null?null:haircutPercentage;
			return this;
		}
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder setMarginPercentage(BigDecimal marginPercentage) {
			this.marginPercentage = marginPercentage==null?null:marginPercentage;
			return this;
		}
		
		@Override
		public CollateralValuationTreatment build() {
			return new CollateralValuationTreatment.CollateralValuationTreatmentImpl(this);
		}
		
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalHaircutPercentage()!=null) return true;
			if (getFxHaircutPercentage()!=null) return true;
			if (getHaircutPercentage()!=null) return true;
			if (getMarginPercentage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralValuationTreatment.CollateralValuationTreatmentBuilder o = (CollateralValuationTreatment.CollateralValuationTreatmentBuilder) other;
			
			
			merger.mergeBasic(getAdditionalHaircutPercentage(), o.getAdditionalHaircutPercentage(), this::setAdditionalHaircutPercentage);
			merger.mergeBasic(getFxHaircutPercentage(), o.getFxHaircutPercentage(), this::setFxHaircutPercentage);
			merger.mergeBasic(getHaircutPercentage(), o.getHaircutPercentage(), this::setHaircutPercentage);
			merger.mergeBasic(getMarginPercentage(), o.getMarginPercentage(), this::setMarginPercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuationTreatment _that = getType().cast(o);
		
			if (!Objects.equals(additionalHaircutPercentage, _that.getAdditionalHaircutPercentage())) return false;
			if (!Objects.equals(fxHaircutPercentage, _that.getFxHaircutPercentage())) return false;
			if (!Objects.equals(haircutPercentage, _that.getHaircutPercentage())) return false;
			if (!Objects.equals(marginPercentage, _that.getMarginPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalHaircutPercentage != null ? additionalHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (fxHaircutPercentage != null ? fxHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (haircutPercentage != null ? haircutPercentage.hashCode() : 0);
			_result = 31 * _result + (marginPercentage != null ? marginPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValuationTreatmentBuilder {" +
				"additionalHaircutPercentage=" + this.additionalHaircutPercentage + ", " +
				"fxHaircutPercentage=" + this.fxHaircutPercentage + ", " +
				"haircutPercentage=" + this.haircutPercentage + ", " +
				"marginPercentage=" + this.marginPercentage +
			'}';
		}
	}
}
