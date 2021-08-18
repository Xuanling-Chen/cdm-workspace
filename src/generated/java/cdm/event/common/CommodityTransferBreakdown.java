package cdm.event.common;

import cdm.base.datetime.TimeUnitEnum;
import cdm.base.math.CapacityUnitEnum;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.event.common.TransferBreakdown.TransferBreakdownBuilder;
import cdm.event.common.TransferBreakdown.TransferBreakdownBuilderImpl;
import cdm.event.common.TransferBreakdown.TransferBreakdownImpl;
import cdm.event.common.meta.CommodityTransferBreakdownMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface CommodityTransferBreakdown extends TransferBreakdown {
	CommodityTransferBreakdown build();
	CommodityTransferBreakdown.CommodityTransferBreakdownBuilder toBuilder();
	
	/**
	 */
	Commodity getCommodity();
	/**
	 */
	BigDecimal getQuantity();
	/**
	 */
	TimeUnitEnum getTimeUnit();
	/**
	 * The transferee and transferor party information.
	 */
	TransferorTransferee getTransferorTransferee();
	/**
	 * The unit of measure, applicable to physical assets.
	 */
	CapacityUnitEnum getUnit();
	final static CommodityTransferBreakdownMeta metaData = new CommodityTransferBreakdownMeta();
	
	@Override
	default RosettaMetaData<? extends CommodityTransferBreakdown> metaData() {
		return metaData;
	} 
			
	static CommodityTransferBreakdown.CommodityTransferBreakdownBuilder builder() {
		return new CommodityTransferBreakdown.CommodityTransferBreakdownBuilderImpl();
	}
	
	default Class<? extends CommodityTransferBreakdown> getType() {
		return CommodityTransferBreakdown.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.event.common.TransferBreakdown.super.process(path, processor);
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processor.processBasic(path.newSubPath("timeUnit"), TimeUnitEnum.class, getTimeUnit(), this);
		processor.processBasic(path.newSubPath("unit"), CapacityUnitEnum.class, getUnit(), this);
		
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("transferorTransferee"), processor, TransferorTransferee.class, getTransferorTransferee());
	}
	
	
	interface CommodityTransferBreakdownBuilder extends CommodityTransferBreakdown, TransferBreakdown.TransferBreakdownBuilder, RosettaModelObjectBuilder {
		Commodity.CommodityBuilder getOrCreateCommodity();
		Commodity.CommodityBuilder getCommodity();
		TransferorTransferee.TransferorTransfereeBuilder getOrCreateTransferorTransferee();
		TransferorTransferee.TransferorTransfereeBuilder getTransferorTransferee();
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setCommodity(Commodity commodity);
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setQuantity(BigDecimal quantity);
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setTimeUnit(TimeUnitEnum timeUnit);
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setTransferorTransferee(TransferorTransferee transferorTransferee);
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setUnit(CapacityUnitEnum unit);
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder addLineage(Lineage lineage);
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder addLineage(Lineage lineage, int _idx);
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder addLineage(List<? extends Lineage> lineage);
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setLineage(List<? extends Lineage> lineage);
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setIdentifier(FieldWithMetaString identifier);
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setIdentifierValue(String identifier);
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setTransferCalculation(TransferCalculation transferCalculation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			TransferBreakdown.TransferBreakdownBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processor.processBasic(path.newSubPath("timeUnit"), TimeUnitEnum.class, getTimeUnit(), this);
			processor.processBasic(path.newSubPath("unit"), CapacityUnitEnum.class, getUnit(), this);
			
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("transferorTransferee"), processor, TransferorTransferee.TransferorTransfereeBuilder.class, getTransferorTransferee());
		}
		
	}
	
	//CommodityTransferBreakdown.CommodityTransferBreakdownImpl
	class CommodityTransferBreakdownImpl extends TransferBreakdown.TransferBreakdownImpl implements CommodityTransferBreakdown {
		private final Commodity commodity;
		private final BigDecimal quantity;
		private final TimeUnitEnum timeUnit;
		private final TransferorTransferee transferorTransferee;
		private final CapacityUnitEnum unit;
		
		protected CommodityTransferBreakdownImpl(CommodityTransferBreakdown.CommodityTransferBreakdownBuilder builder) {
			super(builder);
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.quantity = builder.getQuantity();
			this.timeUnit = builder.getTimeUnit();
			this.transferorTransferee = ofNullable(builder.getTransferorTransferee()).map(f->f.build()).orElse(null);
			this.unit = builder.getUnit();
		}
		
		@Override
		public Commodity getCommodity() {
			return commodity;
		}
		
		@Override
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		public TimeUnitEnum getTimeUnit() {
			return timeUnit;
		}
		
		@Override
		public TransferorTransferee getTransferorTransferee() {
			return transferorTransferee;
		}
		
		@Override
		public CapacityUnitEnum getUnit() {
			return unit;
		}
		
		@Override
		public CommodityTransferBreakdown build() {
			return this;
		}
		
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder toBuilder() {
			CommodityTransferBreakdown.CommodityTransferBreakdownBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityTransferBreakdown.CommodityTransferBreakdownBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getTimeUnit()).ifPresent(builder::setTimeUnit);
			ofNullable(getTransferorTransferee()).ifPresent(builder::setTransferorTransferee);
			ofNullable(getUnit()).ifPresent(builder::setUnit);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityTransferBreakdown _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(timeUnit, _that.getTimeUnit())) return false;
			if (!Objects.equals(transferorTransferee, _that.getTransferorTransferee())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (timeUnit != null ? timeUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (transferorTransferee != null ? transferorTransferee.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityTransferBreakdown {" +
				"commodity=" + this.commodity + ", " +
				"quantity=" + this.quantity + ", " +
				"timeUnit=" + this.timeUnit + ", " +
				"transferorTransferee=" + this.transferorTransferee + ", " +
				"unit=" + this.unit +
			'}' + " " + super.toString();
		}
	}
	
	//CommodityTransferBreakdown.CommodityTransferBreakdownBuilderImpl
	class CommodityTransferBreakdownBuilderImpl extends TransferBreakdown.TransferBreakdownBuilderImpl  implements CommodityTransferBreakdown.CommodityTransferBreakdownBuilder {
	
		protected Commodity.CommodityBuilder commodity;
		protected BigDecimal quantity;
		protected TimeUnitEnum timeUnit;
		protected TransferorTransferee.TransferorTransfereeBuilder transferorTransferee;
		protected CapacityUnitEnum unit;
	
		public CommodityTransferBreakdownBuilderImpl() {
		}
	
		@Override
		public Commodity.CommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateCommodity() {
			Commodity.CommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = Commodity.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		public TimeUnitEnum getTimeUnit() {
			return timeUnit;
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder getTransferorTransferee() {
			return transferorTransferee;
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder getOrCreateTransferorTransferee() {
			TransferorTransferee.TransferorTransfereeBuilder result;
			if (transferorTransferee!=null) {
				result = transferorTransferee;
			}
			else {
				result = transferorTransferee = TransferorTransferee.builder();
			}
			
			return result;
		}
		
		@Override
		public CapacityUnitEnum getUnit() {
			return unit;
		}
		
	
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setQuantity(BigDecimal quantity) {
			this.quantity = quantity==null?null:quantity;
			return this;
		}
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setTimeUnit(TimeUnitEnum timeUnit) {
			this.timeUnit = timeUnit==null?null:timeUnit;
			return this;
		}
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setTransferorTransferee(TransferorTransferee transferorTransferee) {
			this.transferorTransferee = transferorTransferee==null?null:transferorTransferee.toBuilder();
			return this;
		}
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setUnit(CapacityUnitEnum unit) {
			this.unit = unit==null?null:unit;
			return this;
		}
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder addLineage(Lineage lineage) {
			if (lineage!=null) this.lineage.add(lineage.toBuilder());
			return this;
		}
		
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder addLineage(Lineage lineage, int _idx) {
			getIndex(this.lineage, _idx, () -> lineage.toBuilder());
			return this;
		}
		@Override 
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder addLineage(List<? extends Lineage> lineages) {
			if (lineages != null) {
				for (Lineage toAdd : lineages) {
					this.lineage.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setLineage(List<? extends Lineage> lineages) {
			if (lineages == null)  {
				this.lineage = new ArrayList<>();
			}
			else {
				this.lineage = lineages.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setIdentifier(FieldWithMetaString identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setIdentifierValue(String identifier) {
			this.getOrCreateIdentifier().setValue(identifier);
			return this;
		}
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder setTransferCalculation(TransferCalculation transferCalculation) {
			this.transferCalculation = transferCalculation==null?null:transferCalculation.toBuilder();
			return this;
		}
		
		@Override
		public CommodityTransferBreakdown build() {
			return new CommodityTransferBreakdown.CommodityTransferBreakdownImpl(this);
		}
		
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder prune() {
			super.prune();
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (transferorTransferee!=null && !transferorTransferee.prune().hasData()) transferorTransferee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getQuantity()!=null) return true;
			if (getTimeUnit()!=null) return true;
			if (getTransferorTransferee()!=null && getTransferorTransferee().hasData()) return true;
			if (getUnit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityTransferBreakdown.CommodityTransferBreakdownBuilder o = (CommodityTransferBreakdown.CommodityTransferBreakdownBuilder) other;
			
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getTransferorTransferee(), o.getTransferorTransferee(), this::setTransferorTransferee);
			
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeBasic(getTimeUnit(), o.getTimeUnit(), this::setTimeUnit);
			merger.mergeBasic(getUnit(), o.getUnit(), this::setUnit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityTransferBreakdown _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(timeUnit, _that.getTimeUnit())) return false;
			if (!Objects.equals(transferorTransferee, _that.getTransferorTransferee())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (timeUnit != null ? timeUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (transferorTransferee != null ? transferorTransferee.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityTransferBreakdownBuilder {" +
				"commodity=" + this.commodity + ", " +
				"quantity=" + this.quantity + ", " +
				"timeUnit=" + this.timeUnit + ", " +
				"transferorTransferee=" + this.transferorTransferee + ", " +
				"unit=" + this.unit +
			'}' + " " + super.toString();
		}
	}
}
