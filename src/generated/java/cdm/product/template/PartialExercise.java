package cdm.product.template;

import cdm.observable.asset.Money;
import cdm.observable.asset.Money;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder;
import cdm.product.template.meta.PartialExerciseMeta;
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
 * A class defining partial exercise. As defined in the 2000 ISDA Definitions, Section 12.3 Partial Exercise, the buyer of the option may exercise all or less than all the notional amount of the underlying swap but may not be less than the minimum notional amount (if specified) and must be an integral multiple of the integral multiple amount if specified.
 * @version ${project.version}
 */
@RosettaClass

public interface PartialExercise extends RosettaModelObject {
	PartialExercise build();
	PartialExercise.PartialExerciseBuilder toBuilder();
	
	/**
	 * A notional amount which restricts the amount of notional that can be exercised when partial exercise or multiple exercise is applicable. The integral multiple amount defines a lower limit of notional that can be exercised and also defines a unit multiple of notional that can be exercised, i.e. only integer multiples of this amount can be exercised.
	 */
	BigDecimal getIntegralMultipleAmount();
	/**
	 * The minimum notional amount that can be exercised on a given exercise date. See multipleExercise.
	 */
	BigDecimal getMinimumNotionalAmount();
	/**
	 * The minimum number of options that can be exercised on a given exercise date.
	 */
	Integer getMinimumNumberOfOptions();
	/**
	 * A pointer style reference to the associated notional schedule defined elsewhere in the document. This element has been made optional as part of its integration in the OptionBaseExtended, because not required for the options on securities.
	 */
	ReferenceWithMetaMoney getNotionaReference();
	final static PartialExerciseMeta metaData = new PartialExerciseMeta();
	
	@Override
	default RosettaMetaData<? extends PartialExercise> metaData() {
		return metaData;
	} 
			
	static PartialExercise.PartialExerciseBuilder builder() {
		return new PartialExercise.PartialExerciseBuilderImpl();
	}
	
	default Class<? extends PartialExercise> getType() {
		return PartialExercise.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("integralMultipleAmount"), BigDecimal.class, getIntegralMultipleAmount(), this);
		processor.processBasic(path.newSubPath("minimumNotionalAmount"), BigDecimal.class, getMinimumNotionalAmount(), this);
		processor.processBasic(path.newSubPath("minimumNumberOfOptions"), Integer.class, getMinimumNumberOfOptions(), this);
		
		processRosetta(path.newSubPath("notionaReference"), processor, ReferenceWithMetaMoney.class, getNotionaReference());
	}
	
	
	interface PartialExerciseBuilder extends PartialExercise, RosettaModelObjectBuilder {
		ReferenceWithMetaMoneyBuilder getOrCreateNotionaReference();
		ReferenceWithMetaMoneyBuilder getNotionaReference();
		PartialExercise.PartialExerciseBuilder setIntegralMultipleAmount(BigDecimal integralMultipleAmount);
		PartialExercise.PartialExerciseBuilder setMinimumNotionalAmount(BigDecimal minimumNotionalAmount);
		PartialExercise.PartialExerciseBuilder setMinimumNumberOfOptions(Integer minimumNumberOfOptions);
		PartialExercise.PartialExerciseBuilder setNotionaReference(ReferenceWithMetaMoney notionaReference);
		PartialExercise.PartialExerciseBuilder setNotionaReferenceValue(Money notionaReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("integralMultipleAmount"), BigDecimal.class, getIntegralMultipleAmount(), this);
			processor.processBasic(path.newSubPath("minimumNotionalAmount"), BigDecimal.class, getMinimumNotionalAmount(), this);
			processor.processBasic(path.newSubPath("minimumNumberOfOptions"), Integer.class, getMinimumNumberOfOptions(), this);
			
			processRosetta(path.newSubPath("notionaReference"), processor, ReferenceWithMetaMoneyBuilder.class, getNotionaReference());
		}
		
	}
	
	//PartialExercise.PartialExerciseImpl
	class PartialExerciseImpl implements PartialExercise {
		private final BigDecimal integralMultipleAmount;
		private final BigDecimal minimumNotionalAmount;
		private final Integer minimumNumberOfOptions;
		private final ReferenceWithMetaMoney notionaReference;
		
		protected PartialExerciseImpl(PartialExercise.PartialExerciseBuilder builder) {
			this.integralMultipleAmount = builder.getIntegralMultipleAmount();
			this.minimumNotionalAmount = builder.getMinimumNotionalAmount();
			this.minimumNumberOfOptions = builder.getMinimumNumberOfOptions();
			this.notionaReference = ofNullable(builder.getNotionaReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getIntegralMultipleAmount() {
			return integralMultipleAmount;
		}
		
		@Override
		public BigDecimal getMinimumNotionalAmount() {
			return minimumNotionalAmount;
		}
		
		@Override
		public Integer getMinimumNumberOfOptions() {
			return minimumNumberOfOptions;
		}
		
		@Override
		public ReferenceWithMetaMoney getNotionaReference() {
			return notionaReference;
		}
		
		@Override
		public PartialExercise build() {
			return this;
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder toBuilder() {
			PartialExercise.PartialExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartialExercise.PartialExerciseBuilder builder) {
			ofNullable(getIntegralMultipleAmount()).ifPresent(builder::setIntegralMultipleAmount);
			ofNullable(getMinimumNotionalAmount()).ifPresent(builder::setMinimumNotionalAmount);
			ofNullable(getMinimumNumberOfOptions()).ifPresent(builder::setMinimumNumberOfOptions);
			ofNullable(getNotionaReference()).ifPresent(builder::setNotionaReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartialExercise _that = getType().cast(o);
		
			if (!Objects.equals(integralMultipleAmount, _that.getIntegralMultipleAmount())) return false;
			if (!Objects.equals(minimumNotionalAmount, _that.getMinimumNotionalAmount())) return false;
			if (!Objects.equals(minimumNumberOfOptions, _that.getMinimumNumberOfOptions())) return false;
			if (!Objects.equals(notionaReference, _that.getNotionaReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (integralMultipleAmount != null ? integralMultipleAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalAmount != null ? minimumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNumberOfOptions != null ? minimumNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (notionaReference != null ? notionaReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartialExercise {" +
				"integralMultipleAmount=" + this.integralMultipleAmount + ", " +
				"minimumNotionalAmount=" + this.minimumNotionalAmount + ", " +
				"minimumNumberOfOptions=" + this.minimumNumberOfOptions + ", " +
				"notionaReference=" + this.notionaReference +
			'}';
		}
	}
	
	//PartialExercise.PartialExerciseBuilderImpl
	class PartialExerciseBuilderImpl implements PartialExercise.PartialExerciseBuilder {
	
		protected BigDecimal integralMultipleAmount;
		protected BigDecimal minimumNotionalAmount;
		protected Integer minimumNumberOfOptions;
		protected ReferenceWithMetaMoneyBuilder notionaReference;
	
		public PartialExerciseBuilderImpl() {
		}
	
		@Override
		public BigDecimal getIntegralMultipleAmount() {
			return integralMultipleAmount;
		}
		
		@Override
		public BigDecimal getMinimumNotionalAmount() {
			return minimumNotionalAmount;
		}
		
		@Override
		public Integer getMinimumNumberOfOptions() {
			return minimumNumberOfOptions;
		}
		
		@Override
		public ReferenceWithMetaMoneyBuilder getNotionaReference() {
			return notionaReference;
		}
		
		@Override
		public ReferenceWithMetaMoneyBuilder getOrCreateNotionaReference() {
			ReferenceWithMetaMoneyBuilder result;
			if (notionaReference!=null) {
				result = notionaReference;
			}
			else {
				result = notionaReference = ReferenceWithMetaMoney.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PartialExercise.PartialExerciseBuilder setIntegralMultipleAmount(BigDecimal integralMultipleAmount) {
			this.integralMultipleAmount = integralMultipleAmount==null?null:integralMultipleAmount;
			return this;
		}
		@Override
		public PartialExercise.PartialExerciseBuilder setMinimumNotionalAmount(BigDecimal minimumNotionalAmount) {
			this.minimumNotionalAmount = minimumNotionalAmount==null?null:minimumNotionalAmount;
			return this;
		}
		@Override
		public PartialExercise.PartialExerciseBuilder setMinimumNumberOfOptions(Integer minimumNumberOfOptions) {
			this.minimumNumberOfOptions = minimumNumberOfOptions==null?null:minimumNumberOfOptions;
			return this;
		}
		@Override
		public PartialExercise.PartialExerciseBuilder setNotionaReference(ReferenceWithMetaMoney notionaReference) {
			this.notionaReference = notionaReference==null?null:notionaReference.toBuilder();
			return this;
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder setNotionaReferenceValue(Money notionaReference) {
			this.getOrCreateNotionaReference().setValue(notionaReference);
			return this;
		}
		
		@Override
		public PartialExercise build() {
			return new PartialExercise.PartialExerciseImpl(this);
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartialExercise.PartialExerciseBuilder prune() {
			if (notionaReference!=null && !notionaReference.prune().hasData()) notionaReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIntegralMultipleAmount()!=null) return true;
			if (getMinimumNotionalAmount()!=null) return true;
			if (getMinimumNumberOfOptions()!=null) return true;
			if (getNotionaReference()!=null && getNotionaReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartialExercise.PartialExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartialExercise.PartialExerciseBuilder o = (PartialExercise.PartialExerciseBuilder) other;
			
			merger.mergeRosetta(getNotionaReference(), o.getNotionaReference(), this::setNotionaReference);
			
			merger.mergeBasic(getIntegralMultipleAmount(), o.getIntegralMultipleAmount(), this::setIntegralMultipleAmount);
			merger.mergeBasic(getMinimumNotionalAmount(), o.getMinimumNotionalAmount(), this::setMinimumNotionalAmount);
			merger.mergeBasic(getMinimumNumberOfOptions(), o.getMinimumNumberOfOptions(), this::setMinimumNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartialExercise _that = getType().cast(o);
		
			if (!Objects.equals(integralMultipleAmount, _that.getIntegralMultipleAmount())) return false;
			if (!Objects.equals(minimumNotionalAmount, _that.getMinimumNotionalAmount())) return false;
			if (!Objects.equals(minimumNumberOfOptions, _that.getMinimumNumberOfOptions())) return false;
			if (!Objects.equals(notionaReference, _that.getNotionaReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (integralMultipleAmount != null ? integralMultipleAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalAmount != null ? minimumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNumberOfOptions != null ? minimumNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (notionaReference != null ? notionaReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartialExerciseBuilder {" +
				"integralMultipleAmount=" + this.integralMultipleAmount + ", " +
				"minimumNotionalAmount=" + this.minimumNotionalAmount + ", " +
				"minimumNumberOfOptions=" + this.minimumNumberOfOptions + ", " +
				"notionaReference=" + this.notionaReference +
			'}';
		}
	}
}
