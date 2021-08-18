package cdm.base.datetime;

import cdm.base.datetime.meta.AdjustableOrRelativeDateMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class giving the choice between defining a date as an explicit date together with applicable adjustments or as relative to some other (anchor) date.
 * @version ${project.version}
 */
@RosettaClass

public interface AdjustableOrRelativeDate extends RosettaModelObject, GlobalKey {
	AdjustableOrRelativeDate build();
	AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder toBuilder();
	
	/**
	 * A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 */
	AdjustableDate getAdjustableDate();
	/**
	 */
	MetaFields getMeta();
	/**
	 * A date specified as some offset to another date (the anchor date).
	 */
	AdjustedRelativeDateOffset getRelativeDate();
	final static AdjustableOrRelativeDateMeta metaData = new AdjustableOrRelativeDateMeta();
	
	@Override
	default RosettaMetaData<? extends AdjustableOrRelativeDate> metaData() {
		return metaData;
	} 
			
	static AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder() {
		return new AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilderImpl();
	}
	
	default Class<? extends AdjustableOrRelativeDate> getType() {
		return AdjustableOrRelativeDate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.class, getAdjustableDate());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("relativeDate"), processor, AdjustedRelativeDateOffset.class, getRelativeDate());
	}
	
	
	interface AdjustableOrRelativeDateBuilder extends AdjustableOrRelativeDate, RosettaModelObjectBuilder {
		AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate();
		AdjustableDate.AdjustableDateBuilder getAdjustableDate();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateRelativeDate();
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getRelativeDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setAdjustableDate(AdjustableDate adjustableDate);
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setMeta(MetaFields meta);
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setRelativeDate(AdjustedRelativeDateOffset relativeDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getAdjustableDate());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("relativeDate"), processor, AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder.class, getRelativeDate());
		}
		
	}
	
	//AdjustableOrRelativeDate.AdjustableOrRelativeDateImpl
	class AdjustableOrRelativeDateImpl implements AdjustableOrRelativeDate {
		private final AdjustableDate adjustableDate;
		private final MetaFields meta;
		private final AdjustedRelativeDateOffset relativeDate;
		
		protected AdjustableOrRelativeDateImpl(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder) {
			this.adjustableDate = ofNullable(builder.getAdjustableDate()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.relativeDate = ofNullable(builder.getRelativeDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AdjustableDate getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public AdjustedRelativeDateOffset getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public AdjustableOrRelativeDate build() {
			return this;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder toBuilder() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder) {
			ofNullable(getAdjustableDate()).ifPresent(builder::setAdjustableDate);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getRelativeDate()).ifPresent(builder::setRelativeDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrRelativeDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrRelativeDate {" +
				"adjustableDate=" + this.adjustableDate + ", " +
				"meta=" + this.meta + ", " +
				"relativeDate=" + this.relativeDate +
			'}';
		}
	}
	
	//AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilderImpl
	class AdjustableOrRelativeDateBuilderImpl implements AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder, GlobalKeyBuilder {
	
		protected AdjustableDate.AdjustableDateBuilder adjustableDate;
		protected MetaFields.MetaFieldsBuilder meta;
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder relativeDate;
	
		public AdjustableOrRelativeDateBuilderImpl() {
		}
	
		@Override
		public AdjustableDate.AdjustableDateBuilder getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (adjustableDate!=null) {
				result = adjustableDate;
			}
			else {
				result = adjustableDate = AdjustableDate.builder();
			}
			
			return result;
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
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateRelativeDate() {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder result;
			if (relativeDate!=null) {
				result = relativeDate;
			}
			else {
				result = relativeDate = AdjustedRelativeDateOffset.builder();
			}
			
			return result;
		}
		
	
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setAdjustableDate(AdjustableDate adjustableDate) {
			this.adjustableDate = adjustableDate==null?null:adjustableDate.toBuilder();
			return this;
		}
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setRelativeDate(AdjustedRelativeDateOffset relativeDate) {
			this.relativeDate = relativeDate==null?null:relativeDate.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableOrRelativeDate build() {
			return new AdjustableOrRelativeDate.AdjustableOrRelativeDateImpl(this);
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder prune() {
			if (adjustableDate!=null && !adjustableDate.prune().hasData()) adjustableDate = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (relativeDate!=null && !relativeDate.prune().hasData()) relativeDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustableDate()!=null && getAdjustableDate().hasData()) return true;
			if (getRelativeDate()!=null && getRelativeDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder o = (AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder) other;
			
			merger.mergeRosetta(getAdjustableDate(), o.getAdjustableDate(), this::setAdjustableDate);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getRelativeDate(), o.getRelativeDate(), this::setRelativeDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrRelativeDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrRelativeDateBuilder {" +
				"adjustableDate=" + this.adjustableDate + ", " +
				"meta=" + this.meta + ", " +
				"relativeDate=" + this.relativeDate +
			'}';
		}
	}
}
