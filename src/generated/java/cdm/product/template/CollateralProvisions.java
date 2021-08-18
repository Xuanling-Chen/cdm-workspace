package cdm.product.template;

import cdm.legalagreement.csa.CollateralValuationTreatment;
import cdm.legalagreement.csa.EligibleCollateralSchedule;
import cdm.product.template.meta.CollateralProvisionsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Contains collateral attributes which can also inherit information from a master agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface CollateralProvisions extends RosettaModelObject {
	CollateralProvisions build();
	CollateralProvisions.CollateralProvisionsBuilder toBuilder();
	
	/**
	 * Cash or NonCash collateral
	 */
	CollateralTypeEnum getCollateralType();
	/**
	 * The eligible collateral as specified in relation to the transaction.
	 */
	List<? extends EligibleCollateralSchedule> getEligibleCollateral();
	/**
	 * Specification of the valuation treatment for the specified collateral.
	 */
	CollateralValuationTreatment getMarginPercentage();
	final static CollateralProvisionsMeta metaData = new CollateralProvisionsMeta();
	
	@Override
	default RosettaMetaData<? extends CollateralProvisions> metaData() {
		return metaData;
	} 
			
	static CollateralProvisions.CollateralProvisionsBuilder builder() {
		return new CollateralProvisions.CollateralProvisionsBuilderImpl();
	}
	
	default Class<? extends CollateralProvisions> getType() {
		return CollateralProvisions.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("collateralType"), CollateralTypeEnum.class, getCollateralType(), this);
		
		processRosetta(path.newSubPath("eligibleCollateral"), processor, EligibleCollateralSchedule.class, getEligibleCollateral());
		processRosetta(path.newSubPath("marginPercentage"), processor, CollateralValuationTreatment.class, getMarginPercentage());
	}
	
	
	interface CollateralProvisionsBuilder extends CollateralProvisions, RosettaModelObjectBuilder {
		EligibleCollateralSchedule.EligibleCollateralScheduleBuilder getOrCreateEligibleCollateral(int _index);
		List<? extends EligibleCollateralSchedule.EligibleCollateralScheduleBuilder> getEligibleCollateral();
		CollateralValuationTreatment.CollateralValuationTreatmentBuilder getOrCreateMarginPercentage();
		CollateralValuationTreatment.CollateralValuationTreatmentBuilder getMarginPercentage();
		CollateralProvisions.CollateralProvisionsBuilder setCollateralType(CollateralTypeEnum collateralType);
		CollateralProvisions.CollateralProvisionsBuilder addEligibleCollateral(EligibleCollateralSchedule eligibleCollateral);
		CollateralProvisions.CollateralProvisionsBuilder addEligibleCollateral(EligibleCollateralSchedule eligibleCollateral, int _idx);
		CollateralProvisions.CollateralProvisionsBuilder addEligibleCollateral(List<? extends EligibleCollateralSchedule> eligibleCollateral);
		CollateralProvisions.CollateralProvisionsBuilder setEligibleCollateral(List<? extends EligibleCollateralSchedule> eligibleCollateral);
		CollateralProvisions.CollateralProvisionsBuilder setMarginPercentage(CollateralValuationTreatment marginPercentage);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("collateralType"), CollateralTypeEnum.class, getCollateralType(), this);
			
			processRosetta(path.newSubPath("eligibleCollateral"), processor, EligibleCollateralSchedule.EligibleCollateralScheduleBuilder.class, getEligibleCollateral());
			processRosetta(path.newSubPath("marginPercentage"), processor, CollateralValuationTreatment.CollateralValuationTreatmentBuilder.class, getMarginPercentage());
		}
		
	}
	
	//CollateralProvisions.CollateralProvisionsImpl
	class CollateralProvisionsImpl implements CollateralProvisions {
		private final CollateralTypeEnum collateralType;
		private final List<? extends EligibleCollateralSchedule> eligibleCollateral;
		private final CollateralValuationTreatment marginPercentage;
		
		protected CollateralProvisionsImpl(CollateralProvisions.CollateralProvisionsBuilder builder) {
			this.collateralType = builder.getCollateralType();
			this.eligibleCollateral = ofNullable(builder.getEligibleCollateral()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.marginPercentage = ofNullable(builder.getMarginPercentage()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CollateralTypeEnum getCollateralType() {
			return collateralType;
		}
		
		@Override
		public List<? extends EligibleCollateralSchedule> getEligibleCollateral() {
			return eligibleCollateral;
		}
		
		@Override
		public CollateralValuationTreatment getMarginPercentage() {
			return marginPercentage;
		}
		
		@Override
		public CollateralProvisions build() {
			return this;
		}
		
		@Override
		public CollateralProvisions.CollateralProvisionsBuilder toBuilder() {
			CollateralProvisions.CollateralProvisionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralProvisions.CollateralProvisionsBuilder builder) {
			ofNullable(getCollateralType()).ifPresent(builder::setCollateralType);
			ofNullable(getEligibleCollateral()).ifPresent(builder::setEligibleCollateral);
			ofNullable(getMarginPercentage()).ifPresent(builder::setMarginPercentage);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralProvisions _that = getType().cast(o);
		
			if (!Objects.equals(collateralType, _that.getCollateralType())) return false;
			if (!ListEquals.listEquals(eligibleCollateral, _that.getEligibleCollateral())) return false;
			if (!Objects.equals(marginPercentage, _that.getMarginPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralType != null ? collateralType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eligibleCollateral != null ? eligibleCollateral.hashCode() : 0);
			_result = 31 * _result + (marginPercentage != null ? marginPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralProvisions {" +
				"collateralType=" + this.collateralType + ", " +
				"eligibleCollateral=" + this.eligibleCollateral + ", " +
				"marginPercentage=" + this.marginPercentage +
			'}';
		}
	}
	
	//CollateralProvisions.CollateralProvisionsBuilderImpl
	class CollateralProvisionsBuilderImpl implements CollateralProvisions.CollateralProvisionsBuilder {
	
		protected CollateralTypeEnum collateralType;
		protected List<EligibleCollateralSchedule.EligibleCollateralScheduleBuilder> eligibleCollateral = new ArrayList<>();
		protected CollateralValuationTreatment.CollateralValuationTreatmentBuilder marginPercentage;
	
		public CollateralProvisionsBuilderImpl() {
		}
	
		@Override
		public CollateralTypeEnum getCollateralType() {
			return collateralType;
		}
		
		@Override
		public List<? extends EligibleCollateralSchedule.EligibleCollateralScheduleBuilder> getEligibleCollateral() {
			return eligibleCollateral;
		}
		
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder getOrCreateEligibleCollateral(int _index) {
		
			if (eligibleCollateral==null) {
				this.eligibleCollateral = new ArrayList<>();
			}
			EligibleCollateralSchedule.EligibleCollateralScheduleBuilder result;
			return getIndex(eligibleCollateral, _index, () -> {
						EligibleCollateralSchedule.EligibleCollateralScheduleBuilder newEligibleCollateral = EligibleCollateralSchedule.builder();
						return newEligibleCollateral;
					});
		}
		
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder getMarginPercentage() {
			return marginPercentage;
		}
		
		@Override
		public CollateralValuationTreatment.CollateralValuationTreatmentBuilder getOrCreateMarginPercentage() {
			CollateralValuationTreatment.CollateralValuationTreatmentBuilder result;
			if (marginPercentage!=null) {
				result = marginPercentage;
			}
			else {
				result = marginPercentage = CollateralValuationTreatment.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CollateralProvisions.CollateralProvisionsBuilder setCollateralType(CollateralTypeEnum collateralType) {
			this.collateralType = collateralType==null?null:collateralType;
			return this;
		}
		@Override
		public CollateralProvisions.CollateralProvisionsBuilder addEligibleCollateral(EligibleCollateralSchedule eligibleCollateral) {
			if (eligibleCollateral!=null) this.eligibleCollateral.add(eligibleCollateral.toBuilder());
			return this;
		}
		
		@Override
		public CollateralProvisions.CollateralProvisionsBuilder addEligibleCollateral(EligibleCollateralSchedule eligibleCollateral, int _idx) {
			getIndex(this.eligibleCollateral, _idx, () -> eligibleCollateral.toBuilder());
			return this;
		}
		@Override 
		public CollateralProvisions.CollateralProvisionsBuilder addEligibleCollateral(List<? extends EligibleCollateralSchedule> eligibleCollaterals) {
			if (eligibleCollaterals != null) {
				for (EligibleCollateralSchedule toAdd : eligibleCollaterals) {
					this.eligibleCollateral.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CollateralProvisions.CollateralProvisionsBuilder setEligibleCollateral(List<? extends EligibleCollateralSchedule> eligibleCollaterals) {
			if (eligibleCollaterals == null)  {
				this.eligibleCollateral = new ArrayList<>();
			}
			else {
				this.eligibleCollateral = eligibleCollaterals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CollateralProvisions.CollateralProvisionsBuilder setMarginPercentage(CollateralValuationTreatment marginPercentage) {
			this.marginPercentage = marginPercentage==null?null:marginPercentage.toBuilder();
			return this;
		}
		
		@Override
		public CollateralProvisions build() {
			return new CollateralProvisions.CollateralProvisionsImpl(this);
		}
		
		@Override
		public CollateralProvisions.CollateralProvisionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralProvisions.CollateralProvisionsBuilder prune() {
			eligibleCollateral = eligibleCollateral.stream().filter(b->b!=null).<EligibleCollateralSchedule.EligibleCollateralScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (marginPercentage!=null && !marginPercentage.prune().hasData()) marginPercentage = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralType()!=null) return true;
			if (getEligibleCollateral()!=null && getEligibleCollateral().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMarginPercentage()!=null && getMarginPercentage().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralProvisions.CollateralProvisionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralProvisions.CollateralProvisionsBuilder o = (CollateralProvisions.CollateralProvisionsBuilder) other;
			
			merger.mergeRosetta(getEligibleCollateral(), o.getEligibleCollateral(), this::getOrCreateEligibleCollateral);
			merger.mergeRosetta(getMarginPercentage(), o.getMarginPercentage(), this::setMarginPercentage);
			
			merger.mergeBasic(getCollateralType(), o.getCollateralType(), this::setCollateralType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralProvisions _that = getType().cast(o);
		
			if (!Objects.equals(collateralType, _that.getCollateralType())) return false;
			if (!ListEquals.listEquals(eligibleCollateral, _that.getEligibleCollateral())) return false;
			if (!Objects.equals(marginPercentage, _that.getMarginPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralType != null ? collateralType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eligibleCollateral != null ? eligibleCollateral.hashCode() : 0);
			_result = 31 * _result + (marginPercentage != null ? marginPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralProvisionsBuilder {" +
				"collateralType=" + this.collateralType + ", " +
				"eligibleCollateral=" + this.eligibleCollateral + ", " +
				"marginPercentage=" + this.marginPercentage +
			'}';
		}
	}
}
