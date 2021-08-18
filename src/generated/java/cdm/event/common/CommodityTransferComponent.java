package cdm.event.common;

import cdm.base.datetime.TimeUnitEnum;
import cdm.base.math.CapacityUnitEnum;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.event.common.TransferBase.TransferBaseBuilder;
import cdm.event.common.TransferBase.TransferBaseBuilderImpl;
import cdm.event.common.TransferBase.TransferBaseImpl;
import cdm.event.common.meta.CommodityTransferComponentMeta;
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
import com.rosetta.util.ListEquals;
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

public interface CommodityTransferComponent extends TransferBase {
	CommodityTransferComponent build();
	CommodityTransferComponent.CommodityTransferComponentBuilder toBuilder();
	
	/**
	 * The type of transfer, e.g. Free of Payment.
	 */
	AssetTransferTypeEnum getAssetTransferType();
	/**
	 * The security transfer breakdown, when the transfer corresponds to a net transfer across several components which breakdown is deemed relevant (e.g. the net security transfer related to several contracts).
	 */
	List<? extends CommodityTransferBreakdown> getBreakdown();
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
	final static CommodityTransferComponentMeta metaData = new CommodityTransferComponentMeta();
	
	@Override
	default RosettaMetaData<? extends CommodityTransferComponent> metaData() {
		return metaData;
	} 
			
	static CommodityTransferComponent.CommodityTransferComponentBuilder builder() {
		return new CommodityTransferComponent.CommodityTransferComponentBuilderImpl();
	}
	
	default Class<? extends CommodityTransferComponent> getType() {
		return CommodityTransferComponent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.event.common.TransferBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("assetTransferType"), AssetTransferTypeEnum.class, getAssetTransferType(), this);
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processor.processBasic(path.newSubPath("timeUnit"), TimeUnitEnum.class, getTimeUnit(), this);
		processor.processBasic(path.newSubPath("unit"), CapacityUnitEnum.class, getUnit(), this);
		
		processRosetta(path.newSubPath("breakdown"), processor, CommodityTransferBreakdown.class, getBreakdown());
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("transferorTransferee"), processor, TransferorTransferee.class, getTransferorTransferee());
	}
	
	
	interface CommodityTransferComponentBuilder extends CommodityTransferComponent, TransferBase.TransferBaseBuilder, RosettaModelObjectBuilder {
		CommodityTransferBreakdown.CommodityTransferBreakdownBuilder getOrCreateBreakdown(int _index);
		List<? extends CommodityTransferBreakdown.CommodityTransferBreakdownBuilder> getBreakdown();
		Commodity.CommodityBuilder getOrCreateCommodity();
		Commodity.CommodityBuilder getCommodity();
		TransferorTransferee.TransferorTransfereeBuilder getOrCreateTransferorTransferee();
		TransferorTransferee.TransferorTransfereeBuilder getTransferorTransferee();
		CommodityTransferComponent.CommodityTransferComponentBuilder setAssetTransferType(AssetTransferTypeEnum assetTransferType);
		CommodityTransferComponent.CommodityTransferComponentBuilder addBreakdown(CommodityTransferBreakdown breakdown);
		CommodityTransferComponent.CommodityTransferComponentBuilder addBreakdown(CommodityTransferBreakdown breakdown, int _idx);
		CommodityTransferComponent.CommodityTransferComponentBuilder addBreakdown(List<? extends CommodityTransferBreakdown> breakdown);
		CommodityTransferComponent.CommodityTransferComponentBuilder setBreakdown(List<? extends CommodityTransferBreakdown> breakdown);
		CommodityTransferComponent.CommodityTransferComponentBuilder setCommodity(Commodity commodity);
		CommodityTransferComponent.CommodityTransferComponentBuilder setQuantity(BigDecimal quantity);
		CommodityTransferComponent.CommodityTransferComponentBuilder setTimeUnit(TimeUnitEnum timeUnit);
		CommodityTransferComponent.CommodityTransferComponentBuilder setTransferorTransferee(TransferorTransferee transferorTransferee);
		CommodityTransferComponent.CommodityTransferComponentBuilder setUnit(CapacityUnitEnum unit);
		CommodityTransferComponent.CommodityTransferComponentBuilder setIdentifier(FieldWithMetaString identifier);
		CommodityTransferComponent.CommodityTransferComponentBuilder setIdentifierValue(String identifier);
		CommodityTransferComponent.CommodityTransferComponentBuilder setTransferCalculation(TransferCalculation transferCalculation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			TransferBase.TransferBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("assetTransferType"), AssetTransferTypeEnum.class, getAssetTransferType(), this);
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processor.processBasic(path.newSubPath("timeUnit"), TimeUnitEnum.class, getTimeUnit(), this);
			processor.processBasic(path.newSubPath("unit"), CapacityUnitEnum.class, getUnit(), this);
			
			processRosetta(path.newSubPath("breakdown"), processor, CommodityTransferBreakdown.CommodityTransferBreakdownBuilder.class, getBreakdown());
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("transferorTransferee"), processor, TransferorTransferee.TransferorTransfereeBuilder.class, getTransferorTransferee());
		}
		
	}
	
	//CommodityTransferComponent.CommodityTransferComponentImpl
	class CommodityTransferComponentImpl extends TransferBase.TransferBaseImpl implements CommodityTransferComponent {
		private final AssetTransferTypeEnum assetTransferType;
		private final List<? extends CommodityTransferBreakdown> breakdown;
		private final Commodity commodity;
		private final BigDecimal quantity;
		private final TimeUnitEnum timeUnit;
		private final TransferorTransferee transferorTransferee;
		private final CapacityUnitEnum unit;
		
		protected CommodityTransferComponentImpl(CommodityTransferComponent.CommodityTransferComponentBuilder builder) {
			super(builder);
			this.assetTransferType = builder.getAssetTransferType();
			this.breakdown = ofNullable(builder.getBreakdown()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.quantity = builder.getQuantity();
			this.timeUnit = builder.getTimeUnit();
			this.transferorTransferee = ofNullable(builder.getTransferorTransferee()).map(f->f.build()).orElse(null);
			this.unit = builder.getUnit();
		}
		
		@Override
		public AssetTransferTypeEnum getAssetTransferType() {
			return assetTransferType;
		}
		
		@Override
		public List<? extends CommodityTransferBreakdown> getBreakdown() {
			return breakdown;
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
		public CommodityTransferComponent build() {
			return this;
		}
		
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder toBuilder() {
			CommodityTransferComponent.CommodityTransferComponentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityTransferComponent.CommodityTransferComponentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAssetTransferType()).ifPresent(builder::setAssetTransferType);
			ofNullable(getBreakdown()).ifPresent(builder::setBreakdown);
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
		
			CommodityTransferComponent _that = getType().cast(o);
		
			if (!Objects.equals(assetTransferType, _that.getAssetTransferType())) return false;
			if (!ListEquals.listEquals(breakdown, _that.getBreakdown())) return false;
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
			_result = 31 * _result + (assetTransferType != null ? assetTransferType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (breakdown != null ? breakdown.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (timeUnit != null ? timeUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (transferorTransferee != null ? transferorTransferee.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityTransferComponent {" +
				"assetTransferType=" + this.assetTransferType + ", " +
				"breakdown=" + this.breakdown + ", " +
				"commodity=" + this.commodity + ", " +
				"quantity=" + this.quantity + ", " +
				"timeUnit=" + this.timeUnit + ", " +
				"transferorTransferee=" + this.transferorTransferee + ", " +
				"unit=" + this.unit +
			'}' + " " + super.toString();
		}
	}
	
	//CommodityTransferComponent.CommodityTransferComponentBuilderImpl
	class CommodityTransferComponentBuilderImpl extends TransferBase.TransferBaseBuilderImpl  implements CommodityTransferComponent.CommodityTransferComponentBuilder {
	
		protected AssetTransferTypeEnum assetTransferType;
		protected List<CommodityTransferBreakdown.CommodityTransferBreakdownBuilder> breakdown = new ArrayList<>();
		protected Commodity.CommodityBuilder commodity;
		protected BigDecimal quantity;
		protected TimeUnitEnum timeUnit;
		protected TransferorTransferee.TransferorTransfereeBuilder transferorTransferee;
		protected CapacityUnitEnum unit;
	
		public CommodityTransferComponentBuilderImpl() {
		}
	
		@Override
		public AssetTransferTypeEnum getAssetTransferType() {
			return assetTransferType;
		}
		
		@Override
		public List<? extends CommodityTransferBreakdown.CommodityTransferBreakdownBuilder> getBreakdown() {
			return breakdown;
		}
		
		public CommodityTransferBreakdown.CommodityTransferBreakdownBuilder getOrCreateBreakdown(int _index) {
		
			if (breakdown==null) {
				this.breakdown = new ArrayList<>();
			}
			CommodityTransferBreakdown.CommodityTransferBreakdownBuilder result;
			return getIndex(breakdown, _index, () -> {
						CommodityTransferBreakdown.CommodityTransferBreakdownBuilder newBreakdown = CommodityTransferBreakdown.builder();
						return newBreakdown;
					});
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
		public CommodityTransferComponent.CommodityTransferComponentBuilder setAssetTransferType(AssetTransferTypeEnum assetTransferType) {
			this.assetTransferType = assetTransferType==null?null:assetTransferType;
			return this;
		}
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder addBreakdown(CommodityTransferBreakdown breakdown) {
			if (breakdown!=null) this.breakdown.add(breakdown.toBuilder());
			return this;
		}
		
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder addBreakdown(CommodityTransferBreakdown breakdown, int _idx) {
			getIndex(this.breakdown, _idx, () -> breakdown.toBuilder());
			return this;
		}
		@Override 
		public CommodityTransferComponent.CommodityTransferComponentBuilder addBreakdown(List<? extends CommodityTransferBreakdown> breakdowns) {
			if (breakdowns != null) {
				for (CommodityTransferBreakdown toAdd : breakdowns) {
					this.breakdown.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityTransferComponent.CommodityTransferComponentBuilder setBreakdown(List<? extends CommodityTransferBreakdown> breakdowns) {
			if (breakdowns == null)  {
				this.breakdown = new ArrayList<>();
			}
			else {
				this.breakdown = breakdowns.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder setQuantity(BigDecimal quantity) {
			this.quantity = quantity==null?null:quantity;
			return this;
		}
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder setTimeUnit(TimeUnitEnum timeUnit) {
			this.timeUnit = timeUnit==null?null:timeUnit;
			return this;
		}
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder setTransferorTransferee(TransferorTransferee transferorTransferee) {
			this.transferorTransferee = transferorTransferee==null?null:transferorTransferee.toBuilder();
			return this;
		}
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder setUnit(CapacityUnitEnum unit) {
			this.unit = unit==null?null:unit;
			return this;
		}
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder setIdentifier(FieldWithMetaString identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder setIdentifierValue(String identifier) {
			this.getOrCreateIdentifier().setValue(identifier);
			return this;
		}
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder setTransferCalculation(TransferCalculation transferCalculation) {
			this.transferCalculation = transferCalculation==null?null:transferCalculation.toBuilder();
			return this;
		}
		
		@Override
		public CommodityTransferComponent build() {
			return new CommodityTransferComponent.CommodityTransferComponentImpl(this);
		}
		
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder prune() {
			super.prune();
			breakdown = breakdown.stream().filter(b->b!=null).<CommodityTransferBreakdown.CommodityTransferBreakdownBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (transferorTransferee!=null && !transferorTransferee.prune().hasData()) transferorTransferee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAssetTransferType()!=null) return true;
			if (getBreakdown()!=null && getBreakdown().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getQuantity()!=null) return true;
			if (getTimeUnit()!=null) return true;
			if (getTransferorTransferee()!=null && getTransferorTransferee().hasData()) return true;
			if (getUnit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityTransferComponent.CommodityTransferComponentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityTransferComponent.CommodityTransferComponentBuilder o = (CommodityTransferComponent.CommodityTransferComponentBuilder) other;
			
			merger.mergeRosetta(getBreakdown(), o.getBreakdown(), this::getOrCreateBreakdown);
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getTransferorTransferee(), o.getTransferorTransferee(), this::setTransferorTransferee);
			
			merger.mergeBasic(getAssetTransferType(), o.getAssetTransferType(), this::setAssetTransferType);
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
		
			CommodityTransferComponent _that = getType().cast(o);
		
			if (!Objects.equals(assetTransferType, _that.getAssetTransferType())) return false;
			if (!ListEquals.listEquals(breakdown, _that.getBreakdown())) return false;
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
			_result = 31 * _result + (assetTransferType != null ? assetTransferType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (breakdown != null ? breakdown.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (timeUnit != null ? timeUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (transferorTransferee != null ? transferorTransferee.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityTransferComponentBuilder {" +
				"assetTransferType=" + this.assetTransferType + ", " +
				"breakdown=" + this.breakdown + ", " +
				"commodity=" + this.commodity + ", " +
				"quantity=" + this.quantity + ", " +
				"timeUnit=" + this.timeUnit + ", " +
				"transferorTransferee=" + this.transferorTransferee + ", " +
				"unit=" + this.unit +
			'}' + " " + super.toString();
		}
	}
}
