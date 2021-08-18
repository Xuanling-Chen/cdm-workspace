package cdm.product.template;

import cdm.base.staticdata.party.PayerReceiverEnum;
import cdm.product.template.meta.StrikeMeta;
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
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class describing a single cap or floor rate.
 * @version ${project.version}
 */
@RosettaClass

public interface Strike extends RosettaModelObject, GlobalKey {
	Strike build();
	Strike.StrikeBuilder toBuilder();
	
	/**
	 * The buyer of the option.
	 */
	PayerReceiverEnum getBuyer();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The party that has sold.
	 */
	PayerReceiverEnum getSeller();
	/**
	 * The rate for a cap or floor.
	 */
	BigDecimal getStrikeRate();
	final static StrikeMeta metaData = new StrikeMeta();
	
	@Override
	default RosettaMetaData<? extends Strike> metaData() {
		return metaData;
	} 
			
	static Strike.StrikeBuilder builder() {
		return new Strike.StrikeBuilderImpl();
	}
	
	default Class<? extends Strike> getType() {
		return Strike.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("buyer"), PayerReceiverEnum.class, getBuyer(), this);
		processor.processBasic(path.newSubPath("seller"), PayerReceiverEnum.class, getSeller(), this);
		processor.processBasic(path.newSubPath("strikeRate"), BigDecimal.class, getStrikeRate(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface StrikeBuilder extends Strike, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Strike.StrikeBuilder setBuyer(PayerReceiverEnum buyer);
		Strike.StrikeBuilder setMeta(MetaFields meta);
		Strike.StrikeBuilder setSeller(PayerReceiverEnum seller);
		Strike.StrikeBuilder setStrikeRate(BigDecimal strikeRate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("buyer"), PayerReceiverEnum.class, getBuyer(), this);
			processor.processBasic(path.newSubPath("seller"), PayerReceiverEnum.class, getSeller(), this);
			processor.processBasic(path.newSubPath("strikeRate"), BigDecimal.class, getStrikeRate(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//Strike.StrikeImpl
	class StrikeImpl implements Strike {
		private final PayerReceiverEnum buyer;
		private final MetaFields meta;
		private final PayerReceiverEnum seller;
		private final BigDecimal strikeRate;
		
		protected StrikeImpl(Strike.StrikeBuilder builder) {
			this.buyer = builder.getBuyer();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.seller = builder.getSeller();
			this.strikeRate = builder.getStrikeRate();
		}
		
		@Override
		public PayerReceiverEnum getBuyer() {
			return buyer;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PayerReceiverEnum getSeller() {
			return seller;
		}
		
		@Override
		public BigDecimal getStrikeRate() {
			return strikeRate;
		}
		
		@Override
		public Strike build() {
			return this;
		}
		
		@Override
		public Strike.StrikeBuilder toBuilder() {
			Strike.StrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Strike.StrikeBuilder builder) {
			ofNullable(getBuyer()).ifPresent(builder::setBuyer);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getSeller()).ifPresent(builder::setSeller);
			ofNullable(getStrikeRate()).ifPresent(builder::setStrikeRate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Strike _that = getType().cast(o);
		
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			if (!Objects.equals(strikeRate, _that.getStrikeRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyer != null ? buyer.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikeRate != null ? strikeRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Strike {" +
				"buyer=" + this.buyer + ", " +
				"meta=" + this.meta + ", " +
				"seller=" + this.seller + ", " +
				"strikeRate=" + this.strikeRate +
			'}';
		}
	}
	
	//Strike.StrikeBuilderImpl
	class StrikeBuilderImpl implements Strike.StrikeBuilder, GlobalKeyBuilder {
	
		protected PayerReceiverEnum buyer;
		protected MetaFields.MetaFieldsBuilder meta;
		protected PayerReceiverEnum seller;
		protected BigDecimal strikeRate;
	
		public StrikeBuilderImpl() {
		}
	
		@Override
		public PayerReceiverEnum getBuyer() {
			return buyer;
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
		public PayerReceiverEnum getSeller() {
			return seller;
		}
		
		@Override
		public BigDecimal getStrikeRate() {
			return strikeRate;
		}
		
	
		@Override
		public Strike.StrikeBuilder setBuyer(PayerReceiverEnum buyer) {
			this.buyer = buyer==null?null:buyer;
			return this;
		}
		@Override
		public Strike.StrikeBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Strike.StrikeBuilder setSeller(PayerReceiverEnum seller) {
			this.seller = seller==null?null:seller;
			return this;
		}
		@Override
		public Strike.StrikeBuilder setStrikeRate(BigDecimal strikeRate) {
			this.strikeRate = strikeRate==null?null:strikeRate;
			return this;
		}
		
		@Override
		public Strike build() {
			return new Strike.StrikeImpl(this);
		}
		
		@Override
		public Strike.StrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Strike.StrikeBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBuyer()!=null) return true;
			if (getSeller()!=null) return true;
			if (getStrikeRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Strike.StrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Strike.StrikeBuilder o = (Strike.StrikeBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getBuyer(), o.getBuyer(), this::setBuyer);
			merger.mergeBasic(getSeller(), o.getSeller(), this::setSeller);
			merger.mergeBasic(getStrikeRate(), o.getStrikeRate(), this::setStrikeRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Strike _that = getType().cast(o);
		
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			if (!Objects.equals(strikeRate, _that.getStrikeRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyer != null ? buyer.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikeRate != null ? strikeRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeBuilder {" +
				"buyer=" + this.buyer + ", " +
				"meta=" + this.meta + ", " +
				"seller=" + this.seller + ", " +
				"strikeRate=" + this.strikeRate +
			'}';
		}
	}
}
