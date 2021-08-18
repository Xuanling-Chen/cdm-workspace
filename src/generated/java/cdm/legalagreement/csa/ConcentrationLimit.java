package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.ConcentrationLimitMeta;
import cdm.observable.asset.Money;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to describe concentration limits that may be applicable to eligible collateral criteria.
 * @version ${project.version}
 */
@RosettaClass

public interface ConcentrationLimit extends RosettaModelObject {
	ConcentrationLimit build();
	ConcentrationLimit.ConcentrationLimitBuilder toBuilder();
	
	/**
	 * A set of criteria to describe specific assets that the concentration limits apply to.
	 */
	List<? extends ConcentrationLimitCriteria> getConcentrationLimitCriteria();
	/**
	 * The type of concentration limit to be applied.
	 */
	ConcentrationLimitTypeEnum getConcentrationLimitType();
	/**
	 * perecentage of collateral limit cap-represented as a decimal number - example 25% is 0.25
	 */
	BigDecimal getPercentageCap();
	/**
	 * value of collateral limit cap-represented as a numerical value
	 */
	Money getValueCap();
	final static ConcentrationLimitMeta metaData = new ConcentrationLimitMeta();
	
	@Override
	default RosettaMetaData<? extends ConcentrationLimit> metaData() {
		return metaData;
	} 
			
	static ConcentrationLimit.ConcentrationLimitBuilder builder() {
		return new ConcentrationLimit.ConcentrationLimitBuilderImpl();
	}
	
	default Class<? extends ConcentrationLimit> getType() {
		return ConcentrationLimit.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("concentrationLimitType"), ConcentrationLimitTypeEnum.class, getConcentrationLimitType(), this);
		processor.processBasic(path.newSubPath("percentageCap"), BigDecimal.class, getPercentageCap(), this);
		
		processRosetta(path.newSubPath("concentrationLimitCriteria"), processor, ConcentrationLimitCriteria.class, getConcentrationLimitCriteria());
		processRosetta(path.newSubPath("valueCap"), processor, Money.class, getValueCap());
	}
	
	
	interface ConcentrationLimitBuilder extends ConcentrationLimit, RosettaModelObjectBuilder {
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder getOrCreateConcentrationLimitCriteria(int _index);
		List<? extends ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder> getConcentrationLimitCriteria();
		Money.MoneyBuilder getOrCreateValueCap();
		Money.MoneyBuilder getValueCap();
		ConcentrationLimit.ConcentrationLimitBuilder addConcentrationLimitCriteria(ConcentrationLimitCriteria concentrationLimitCriteria);
		ConcentrationLimit.ConcentrationLimitBuilder addConcentrationLimitCriteria(ConcentrationLimitCriteria concentrationLimitCriteria, int _idx);
		ConcentrationLimit.ConcentrationLimitBuilder addConcentrationLimitCriteria(List<? extends ConcentrationLimitCriteria> concentrationLimitCriteria);
		ConcentrationLimit.ConcentrationLimitBuilder setConcentrationLimitCriteria(List<? extends ConcentrationLimitCriteria> concentrationLimitCriteria);
		ConcentrationLimit.ConcentrationLimitBuilder setConcentrationLimitType(ConcentrationLimitTypeEnum concentrationLimitType);
		ConcentrationLimit.ConcentrationLimitBuilder setPercentageCap(BigDecimal percentageCap);
		ConcentrationLimit.ConcentrationLimitBuilder setValueCap(Money valueCap);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("concentrationLimitType"), ConcentrationLimitTypeEnum.class, getConcentrationLimitType(), this);
			processor.processBasic(path.newSubPath("percentageCap"), BigDecimal.class, getPercentageCap(), this);
			
			processRosetta(path.newSubPath("concentrationLimitCriteria"), processor, ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder.class, getConcentrationLimitCriteria());
			processRosetta(path.newSubPath("valueCap"), processor, Money.MoneyBuilder.class, getValueCap());
		}
		
	}
	
	//ConcentrationLimit.ConcentrationLimitImpl
	class ConcentrationLimitImpl implements ConcentrationLimit {
		private final List<? extends ConcentrationLimitCriteria> concentrationLimitCriteria;
		private final ConcentrationLimitTypeEnum concentrationLimitType;
		private final BigDecimal percentageCap;
		private final Money valueCap;
		
		protected ConcentrationLimitImpl(ConcentrationLimit.ConcentrationLimitBuilder builder) {
			this.concentrationLimitCriteria = ofNullable(builder.getConcentrationLimitCriteria()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.concentrationLimitType = builder.getConcentrationLimitType();
			this.percentageCap = builder.getPercentageCap();
			this.valueCap = ofNullable(builder.getValueCap()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends ConcentrationLimitCriteria> getConcentrationLimitCriteria() {
			return concentrationLimitCriteria;
		}
		
		@Override
		public ConcentrationLimitTypeEnum getConcentrationLimitType() {
			return concentrationLimitType;
		}
		
		@Override
		public BigDecimal getPercentageCap() {
			return percentageCap;
		}
		
		@Override
		public Money getValueCap() {
			return valueCap;
		}
		
		@Override
		public ConcentrationLimit build() {
			return this;
		}
		
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder toBuilder() {
			ConcentrationLimit.ConcentrationLimitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConcentrationLimit.ConcentrationLimitBuilder builder) {
			ofNullable(getConcentrationLimitCriteria()).ifPresent(builder::setConcentrationLimitCriteria);
			ofNullable(getConcentrationLimitType()).ifPresent(builder::setConcentrationLimitType);
			ofNullable(getPercentageCap()).ifPresent(builder::setPercentageCap);
			ofNullable(getValueCap()).ifPresent(builder::setValueCap);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConcentrationLimit _that = getType().cast(o);
		
			if (!ListEquals.listEquals(concentrationLimitCriteria, _that.getConcentrationLimitCriteria())) return false;
			if (!Objects.equals(concentrationLimitType, _that.getConcentrationLimitType())) return false;
			if (!Objects.equals(percentageCap, _that.getPercentageCap())) return false;
			if (!Objects.equals(valueCap, _that.getValueCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (concentrationLimitCriteria != null ? concentrationLimitCriteria.hashCode() : 0);
			_result = 31 * _result + (concentrationLimitType != null ? concentrationLimitType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (percentageCap != null ? percentageCap.hashCode() : 0);
			_result = 31 * _result + (valueCap != null ? valueCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConcentrationLimit {" +
				"concentrationLimitCriteria=" + this.concentrationLimitCriteria + ", " +
				"concentrationLimitType=" + this.concentrationLimitType + ", " +
				"percentageCap=" + this.percentageCap + ", " +
				"valueCap=" + this.valueCap +
			'}';
		}
	}
	
	//ConcentrationLimit.ConcentrationLimitBuilderImpl
	class ConcentrationLimitBuilderImpl implements ConcentrationLimit.ConcentrationLimitBuilder {
	
		protected List<ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder> concentrationLimitCriteria = new ArrayList<>();
		protected ConcentrationLimitTypeEnum concentrationLimitType;
		protected BigDecimal percentageCap;
		protected Money.MoneyBuilder valueCap;
	
		public ConcentrationLimitBuilderImpl() {
		}
	
		@Override
		public List<? extends ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder> getConcentrationLimitCriteria() {
			return concentrationLimitCriteria;
		}
		
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder getOrCreateConcentrationLimitCriteria(int _index) {
		
			if (concentrationLimitCriteria==null) {
				this.concentrationLimitCriteria = new ArrayList<>();
			}
			ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder result;
			return getIndex(concentrationLimitCriteria, _index, () -> {
						ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder newConcentrationLimitCriteria = ConcentrationLimitCriteria.builder();
						return newConcentrationLimitCriteria;
					});
		}
		
		@Override
		public ConcentrationLimitTypeEnum getConcentrationLimitType() {
			return concentrationLimitType;
		}
		
		@Override
		public BigDecimal getPercentageCap() {
			return percentageCap;
		}
		
		@Override
		public Money.MoneyBuilder getValueCap() {
			return valueCap;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateValueCap() {
			Money.MoneyBuilder result;
			if (valueCap!=null) {
				result = valueCap;
			}
			else {
				result = valueCap = Money.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder addConcentrationLimitCriteria(ConcentrationLimitCriteria concentrationLimitCriteria) {
			if (concentrationLimitCriteria!=null) this.concentrationLimitCriteria.add(concentrationLimitCriteria.toBuilder());
			return this;
		}
		
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder addConcentrationLimitCriteria(ConcentrationLimitCriteria concentrationLimitCriteria, int _idx) {
			getIndex(this.concentrationLimitCriteria, _idx, () -> concentrationLimitCriteria.toBuilder());
			return this;
		}
		@Override 
		public ConcentrationLimit.ConcentrationLimitBuilder addConcentrationLimitCriteria(List<? extends ConcentrationLimitCriteria> concentrationLimitCriterias) {
			if (concentrationLimitCriterias != null) {
				for (ConcentrationLimitCriteria toAdd : concentrationLimitCriterias) {
					this.concentrationLimitCriteria.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ConcentrationLimit.ConcentrationLimitBuilder setConcentrationLimitCriteria(List<? extends ConcentrationLimitCriteria> concentrationLimitCriterias) {
			if (concentrationLimitCriterias == null)  {
				this.concentrationLimitCriteria = new ArrayList<>();
			}
			else {
				this.concentrationLimitCriteria = concentrationLimitCriterias.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder setConcentrationLimitType(ConcentrationLimitTypeEnum concentrationLimitType) {
			this.concentrationLimitType = concentrationLimitType==null?null:concentrationLimitType;
			return this;
		}
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder setPercentageCap(BigDecimal percentageCap) {
			this.percentageCap = percentageCap==null?null:percentageCap;
			return this;
		}
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder setValueCap(Money valueCap) {
			this.valueCap = valueCap==null?null:valueCap.toBuilder();
			return this;
		}
		
		@Override
		public ConcentrationLimit build() {
			return new ConcentrationLimit.ConcentrationLimitImpl(this);
		}
		
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder prune() {
			concentrationLimitCriteria = concentrationLimitCriteria.stream().filter(b->b!=null).<ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (valueCap!=null && !valueCap.prune().hasData()) valueCap = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConcentrationLimitCriteria()!=null && getConcentrationLimitCriteria().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getConcentrationLimitType()!=null) return true;
			if (getPercentageCap()!=null) return true;
			if (getValueCap()!=null && getValueCap().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ConcentrationLimit.ConcentrationLimitBuilder o = (ConcentrationLimit.ConcentrationLimitBuilder) other;
			
			merger.mergeRosetta(getConcentrationLimitCriteria(), o.getConcentrationLimitCriteria(), this::getOrCreateConcentrationLimitCriteria);
			merger.mergeRosetta(getValueCap(), o.getValueCap(), this::setValueCap);
			
			merger.mergeBasic(getConcentrationLimitType(), o.getConcentrationLimitType(), this::setConcentrationLimitType);
			merger.mergeBasic(getPercentageCap(), o.getPercentageCap(), this::setPercentageCap);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConcentrationLimit _that = getType().cast(o);
		
			if (!ListEquals.listEquals(concentrationLimitCriteria, _that.getConcentrationLimitCriteria())) return false;
			if (!Objects.equals(concentrationLimitType, _that.getConcentrationLimitType())) return false;
			if (!Objects.equals(percentageCap, _that.getPercentageCap())) return false;
			if (!Objects.equals(valueCap, _that.getValueCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (concentrationLimitCriteria != null ? concentrationLimitCriteria.hashCode() : 0);
			_result = 31 * _result + (concentrationLimitType != null ? concentrationLimitType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (percentageCap != null ? percentageCap.hashCode() : 0);
			_result = 31 * _result + (valueCap != null ? valueCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConcentrationLimitBuilder {" +
				"concentrationLimitCriteria=" + this.concentrationLimitCriteria + ", " +
				"concentrationLimitType=" + this.concentrationLimitType + ", " +
				"percentageCap=" + this.percentageCap + ", " +
				"valueCap=" + this.valueCap +
			'}';
		}
	}
}
