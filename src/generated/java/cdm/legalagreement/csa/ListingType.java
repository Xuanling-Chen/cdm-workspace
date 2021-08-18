package cdm.legalagreement.csa;

import cdm.base.staticdata.asset.common.Index;
import cdm.legalagreement.csa.meta.ListingTypeMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Filter based on an underlying corporate financial official listing defined at a stock exchange.
 * @version ${project.version}
 */
@RosettaClass

public interface ListingType extends RosettaModelObject {
	ListingType build();
	ListingType.ListingTypeBuilder toBuilder();
	
	/**
	 * Filter based on the Primary Stock Exchange facilitating the listing of companies, exchange of Stocks, Exchange traded Derivatives, Bonds, and other Securities expressed in ISO standard 10383.
	 */
	FieldWithMetaString getExchange();
	/**
	 * Filter based on an index that measures a stock market, or a subset of a stock market.
	 */
	Index getIndex();
	/**
	 * Filter based on an industry sector defined under a system for classifying industry types such as ‘Global Industry Classification Standard (GICS)’ and ‘North American Industry Classification System (NAICS)’
	 */
	FieldWithMetaString getSector();
	final static ListingTypeMeta metaData = new ListingTypeMeta();
	
	@Override
	default RosettaMetaData<? extends ListingType> metaData() {
		return metaData;
	} 
			
	static ListingType.ListingTypeBuilder builder() {
		return new ListingType.ListingTypeBuilderImpl();
	}
	
	default Class<? extends ListingType> getType() {
		return ListingType.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("exchange"), processor, FieldWithMetaString.class, getExchange());
		processRosetta(path.newSubPath("index"), processor, Index.class, getIndex());
		processRosetta(path.newSubPath("sector"), processor, FieldWithMetaString.class, getSector());
	}
	
	
	interface ListingTypeBuilder extends ListingType, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateExchange();
		FieldWithMetaStringBuilder getExchange();
		Index.IndexBuilder getOrCreateIndex();
		Index.IndexBuilder getIndex();
		FieldWithMetaStringBuilder getOrCreateSector();
		FieldWithMetaStringBuilder getSector();
		ListingType.ListingTypeBuilder setExchange(FieldWithMetaString exchange);
		ListingType.ListingTypeBuilder setExchangeValue(String exchange);
		ListingType.ListingTypeBuilder setIndex(Index index);
		ListingType.ListingTypeBuilder setSector(FieldWithMetaString sector);
		ListingType.ListingTypeBuilder setSectorValue(String sector);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("exchange"), processor, FieldWithMetaStringBuilder.class, getExchange());
			processRosetta(path.newSubPath("index"), processor, Index.IndexBuilder.class, getIndex());
			processRosetta(path.newSubPath("sector"), processor, FieldWithMetaStringBuilder.class, getSector());
		}
		
	}
	
	//ListingType.ListingTypeImpl
	class ListingTypeImpl implements ListingType {
		private final FieldWithMetaString exchange;
		private final Index index;
		private final FieldWithMetaString sector;
		
		protected ListingTypeImpl(ListingType.ListingTypeBuilder builder) {
			this.exchange = ofNullable(builder.getExchange()).map(f->f.build()).orElse(null);
			this.index = ofNullable(builder.getIndex()).map(f->f.build()).orElse(null);
			this.sector = ofNullable(builder.getSector()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaString getExchange() {
			return exchange;
		}
		
		@Override
		public Index getIndex() {
			return index;
		}
		
		@Override
		public FieldWithMetaString getSector() {
			return sector;
		}
		
		@Override
		public ListingType build() {
			return this;
		}
		
		@Override
		public ListingType.ListingTypeBuilder toBuilder() {
			ListingType.ListingTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ListingType.ListingTypeBuilder builder) {
			ofNullable(getExchange()).ifPresent(builder::setExchange);
			ofNullable(getIndex()).ifPresent(builder::setIndex);
			ofNullable(getSector()).ifPresent(builder::setSector);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ListingType _that = getType().cast(o);
		
			if (!Objects.equals(exchange, _that.getExchange())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			if (!Objects.equals(sector, _that.getSector())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchange != null ? exchange.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			_result = 31 * _result + (sector != null ? sector.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ListingType {" +
				"exchange=" + this.exchange + ", " +
				"index=" + this.index + ", " +
				"sector=" + this.sector +
			'}';
		}
	}
	
	//ListingType.ListingTypeBuilderImpl
	class ListingTypeBuilderImpl implements ListingType.ListingTypeBuilder {
	
		protected FieldWithMetaStringBuilder exchange;
		protected Index.IndexBuilder index;
		protected FieldWithMetaStringBuilder sector;
	
		public ListingTypeBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getExchange() {
			return exchange;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateExchange() {
			FieldWithMetaStringBuilder result;
			if (exchange!=null) {
				result = exchange;
			}
			else {
				result = exchange = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public Index.IndexBuilder getIndex() {
			return index;
		}
		
		@Override
		public Index.IndexBuilder getOrCreateIndex() {
			Index.IndexBuilder result;
			if (index!=null) {
				result = index;
			}
			else {
				result = index = Index.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getSector() {
			return sector;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateSector() {
			FieldWithMetaStringBuilder result;
			if (sector!=null) {
				result = sector;
			}
			else {
				result = sector = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ListingType.ListingTypeBuilder setExchange(FieldWithMetaString exchange) {
			this.exchange = exchange==null?null:exchange.toBuilder();
			return this;
		}
		
		@Override
		public ListingType.ListingTypeBuilder setExchangeValue(String exchange) {
			this.getOrCreateExchange().setValue(exchange);
			return this;
		}
		@Override
		public ListingType.ListingTypeBuilder setIndex(Index index) {
			this.index = index==null?null:index.toBuilder();
			return this;
		}
		@Override
		public ListingType.ListingTypeBuilder setSector(FieldWithMetaString sector) {
			this.sector = sector==null?null:sector.toBuilder();
			return this;
		}
		
		@Override
		public ListingType.ListingTypeBuilder setSectorValue(String sector) {
			this.getOrCreateSector().setValue(sector);
			return this;
		}
		
		@Override
		public ListingType build() {
			return new ListingType.ListingTypeImpl(this);
		}
		
		@Override
		public ListingType.ListingTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ListingType.ListingTypeBuilder prune() {
			if (exchange!=null && !exchange.prune().hasData()) exchange = null;
			if (index!=null && !index.prune().hasData()) index = null;
			if (sector!=null && !sector.prune().hasData()) sector = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExchange()!=null) return true;
			if (getIndex()!=null && getIndex().hasData()) return true;
			if (getSector()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ListingType.ListingTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ListingType.ListingTypeBuilder o = (ListingType.ListingTypeBuilder) other;
			
			merger.mergeRosetta(getExchange(), o.getExchange(), this::setExchange);
			merger.mergeRosetta(getIndex(), o.getIndex(), this::setIndex);
			merger.mergeRosetta(getSector(), o.getSector(), this::setSector);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ListingType _that = getType().cast(o);
		
			if (!Objects.equals(exchange, _that.getExchange())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			if (!Objects.equals(sector, _that.getSector())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchange != null ? exchange.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			_result = 31 * _result + (sector != null ? sector.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ListingTypeBuilder {" +
				"exchange=" + this.exchange + ", " +
				"index=" + this.index + ", " +
				"sector=" + this.sector +
			'}';
		}
	}
}
