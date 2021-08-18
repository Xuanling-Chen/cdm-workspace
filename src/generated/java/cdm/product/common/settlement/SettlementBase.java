package cdm.product.common.settlement;

import cdm.product.common.settlement.meta.SettlementBaseMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A base class to be extended by the SettlementTerms class.
 * @version ${project.version}
 */
@RosettaClass

public interface SettlementBase extends RosettaModelObject, GlobalKey {
	SettlementBase build();
	SettlementBase.SettlementBaseBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 * The settlement currency is to be specified when the Settlement Amount cannot be known in advance. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getSettlementCurrency();
	/**
	 * The date on which the settlement amount will be paid, subject to adjustment in accordance with any applicable business day convention. This component would not be present for a mandatory early termination provision where the cash settlement payment date is the mandatory early termination date.
	 */
	SettlementDate getSettlementDate();
	/**
	 * Whether the settlement will be cash, physical, by election, ...
	 */
	SettlementTypeEnum getSettlementType();
	/**
	 * The qualification as to how the transfer will settle, e.g. a DvP settlement.
	 */
	TransferSettlementEnum getTransferSettlementType();
	final static SettlementBaseMeta metaData = new SettlementBaseMeta();
	
	@Override
	default RosettaMetaData<? extends SettlementBase> metaData() {
		return metaData;
	} 
			
	static SettlementBase.SettlementBaseBuilder builder() {
		return new SettlementBase.SettlementBaseBuilderImpl();
	}
	
	default Class<? extends SettlementBase> getType() {
		return SettlementBase.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processor.processBasic(path.newSubPath("transferSettlementType"), TransferSettlementEnum.class, getTransferSettlementType(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("settlementCurrency"), processor, FieldWithMetaString.class, getSettlementCurrency());
		processRosetta(path.newSubPath("settlementDate"), processor, SettlementDate.class, getSettlementDate());
	}
	
	
	interface SettlementBaseBuilder extends SettlementBase, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaStringBuilder getOrCreateSettlementCurrency();
		FieldWithMetaStringBuilder getSettlementCurrency();
		SettlementDate.SettlementDateBuilder getOrCreateSettlementDate();
		SettlementDate.SettlementDateBuilder getSettlementDate();
		SettlementBase.SettlementBaseBuilder setMeta(MetaFields meta);
		SettlementBase.SettlementBaseBuilder setSettlementCurrency(FieldWithMetaString settlementCurrency);
		SettlementBase.SettlementBaseBuilder setSettlementCurrencyValue(String settlementCurrency);
		SettlementBase.SettlementBaseBuilder setSettlementDate(SettlementDate settlementDate);
		SettlementBase.SettlementBaseBuilder setSettlementType(SettlementTypeEnum settlementType);
		SettlementBase.SettlementBaseBuilder setTransferSettlementType(TransferSettlementEnum transferSettlementType);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processor.processBasic(path.newSubPath("transferSettlementType"), TransferSettlementEnum.class, getTransferSettlementType(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("settlementCurrency"), processor, FieldWithMetaStringBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("settlementDate"), processor, SettlementDate.SettlementDateBuilder.class, getSettlementDate());
		}
		
	}
	
	//SettlementBase.SettlementBaseImpl
	class SettlementBaseImpl implements SettlementBase {
		private final MetaFields meta;
		private final FieldWithMetaString settlementCurrency;
		private final SettlementDate settlementDate;
		private final SettlementTypeEnum settlementType;
		private final TransferSettlementEnum transferSettlementType;
		
		protected SettlementBaseImpl(SettlementBase.SettlementBaseBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementType = builder.getSettlementType();
			this.transferSettlementType = builder.getTransferSettlementType();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public FieldWithMetaString getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public SettlementDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		public TransferSettlementEnum getTransferSettlementType() {
			return transferSettlementType;
		}
		
		@Override
		public SettlementBase build() {
			return this;
		}
		
		@Override
		public SettlementBase.SettlementBaseBuilder toBuilder() {
			SettlementBase.SettlementBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementBase.SettlementBaseBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getTransferSettlementType()).ifPresent(builder::setTransferSettlementType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementBase _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(transferSettlementType, _that.getTransferSettlementType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (transferSettlementType != null ? transferSettlementType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementBase {" +
				"meta=" + this.meta + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementType=" + this.settlementType + ", " +
				"transferSettlementType=" + this.transferSettlementType +
			'}';
		}
	}
	
	//SettlementBase.SettlementBaseBuilderImpl
	class SettlementBaseBuilderImpl implements SettlementBase.SettlementBaseBuilder, GlobalKeyBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected FieldWithMetaStringBuilder settlementCurrency;
		protected SettlementDate.SettlementDateBuilder settlementDate;
		protected SettlementTypeEnum settlementType;
		protected TransferSettlementEnum transferSettlementType;
	
		public SettlementBaseBuilderImpl() {
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
		public FieldWithMetaStringBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateSettlementCurrency() {
			FieldWithMetaStringBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public SettlementDate.SettlementDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public SettlementDate.SettlementDateBuilder getOrCreateSettlementDate() {
			SettlementDate.SettlementDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = SettlementDate.builder();
			}
			
			return result;
		}
		
		@Override
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		public TransferSettlementEnum getTransferSettlementType() {
			return transferSettlementType;
		}
		
	
		@Override
		public SettlementBase.SettlementBaseBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public SettlementBase.SettlementBaseBuilder setSettlementCurrency(FieldWithMetaString settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		
		@Override
		public SettlementBase.SettlementBaseBuilder setSettlementCurrencyValue(String settlementCurrency) {
			this.getOrCreateSettlementCurrency().setValue(settlementCurrency);
			return this;
		}
		@Override
		public SettlementBase.SettlementBaseBuilder setSettlementDate(SettlementDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		public SettlementBase.SettlementBaseBuilder setSettlementType(SettlementTypeEnum settlementType) {
			this.settlementType = settlementType==null?null:settlementType;
			return this;
		}
		@Override
		public SettlementBase.SettlementBaseBuilder setTransferSettlementType(TransferSettlementEnum transferSettlementType) {
			this.transferSettlementType = transferSettlementType==null?null:transferSettlementType;
			return this;
		}
		
		@Override
		public SettlementBase build() {
			return new SettlementBase.SettlementBaseImpl(this);
		}
		
		@Override
		public SettlementBase.SettlementBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementBase.SettlementBaseBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementCurrency()!=null) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementType()!=null) return true;
			if (getTransferSettlementType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementBase.SettlementBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementBase.SettlementBaseBuilder o = (SettlementBase.SettlementBaseBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			merger.mergeBasic(getTransferSettlementType(), o.getTransferSettlementType(), this::setTransferSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementBase _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(transferSettlementType, _that.getTransferSettlementType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (transferSettlementType != null ? transferSettlementType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementBaseBuilder {" +
				"meta=" + this.meta + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementType=" + this.settlementType + ", " +
				"transferSettlementType=" + this.transferSettlementType +
			'}';
		}
	}
}
