package cdm.base.datetime;

import cdm.base.datetime.meta.AdjustableDatesMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaDate.FieldWithMetaDateBuilder;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class for defining a series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the dates.
 * @version ${project.version}
 */
@RosettaClass

public interface AdjustableDates extends RosettaModelObject, GlobalKey {
	AdjustableDates build();
	AdjustableDates.AdjustableDatesBuilder toBuilder();
	
	/**
	 * The date(s) once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	List<? extends FieldWithMetaDate> getAdjustedDate();
	/**
	 * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 */
	MetaFields getMeta();
	/**
	 * A date subject to adjustment.
	 */
	List<? extends Date> getUnadjustedDate();
	final static AdjustableDatesMeta metaData = new AdjustableDatesMeta();
	
	@Override
	default RosettaMetaData<? extends AdjustableDates> metaData() {
		return metaData;
	} 
			
	static AdjustableDates.AdjustableDatesBuilder builder() {
		return new AdjustableDates.AdjustableDatesBuilderImpl();
	}
	
	default Class<? extends AdjustableDates> getType() {
		return AdjustableDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedDate"), Date.class, getUnadjustedDate(), this);
		
		processRosetta(path.newSubPath("adjustedDate"), processor, FieldWithMetaDate.class, getAdjustedDate(), AttributeMeta.GLOBAL_KEY_FIELD);
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface AdjustableDatesBuilder extends AdjustableDates, RosettaModelObjectBuilder {
		FieldWithMetaDateBuilder getOrCreateAdjustedDate(int _index);
		List<? extends FieldWithMetaDateBuilder> getAdjustedDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		AdjustableDates.AdjustableDatesBuilder addAdjustedDate(FieldWithMetaDate adjustedDate);
		AdjustableDates.AdjustableDatesBuilder addAdjustedDate(FieldWithMetaDate adjustedDate, int _idx);
		AdjustableDates.AdjustableDatesBuilder addAdjustedDateValue(Date adjustedDate);
		AdjustableDates.AdjustableDatesBuilder addAdjustedDateValue(Date adjustedDate, int _idx);
		AdjustableDates.AdjustableDatesBuilder addAdjustedDate(List<? extends FieldWithMetaDate> adjustedDate);
		AdjustableDates.AdjustableDatesBuilder setAdjustedDate(List<? extends FieldWithMetaDate> adjustedDate);
		AdjustableDates.AdjustableDatesBuilder addAdjustedDateValue(List<? extends Date> adjustedDate);
		AdjustableDates.AdjustableDatesBuilder setAdjustedDateValue(List<? extends Date> adjustedDate);
		AdjustableDates.AdjustableDatesBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		AdjustableDates.AdjustableDatesBuilder setMeta(MetaFields meta);
		AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(Date unadjustedDate);
		AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(Date unadjustedDate, int _idx);
		AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(List<? extends Date> unadjustedDate);
		AdjustableDates.AdjustableDatesBuilder setUnadjustedDate(List<? extends Date> unadjustedDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("unadjustedDate"), Date.class, getUnadjustedDate(), this);
			
			processRosetta(path.newSubPath("adjustedDate"), processor, FieldWithMetaDateBuilder.class, getAdjustedDate(), AttributeMeta.GLOBAL_KEY_FIELD);
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//AdjustableDates.AdjustableDatesImpl
	class AdjustableDatesImpl implements AdjustableDates {
		private final List<? extends FieldWithMetaDate> adjustedDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final MetaFields meta;
		private final List<? extends Date> unadjustedDate;
		
		protected AdjustableDatesImpl(AdjustableDates.AdjustableDatesBuilder builder) {
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.unadjustedDate = ofNullable(builder.getUnadjustedDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		public List<? extends FieldWithMetaDate> getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends Date> getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		public AdjustableDates build() {
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder toBuilder() {
			AdjustableDates.AdjustableDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableDates.AdjustableDatesBuilder builder) {
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(unadjustedDate, _that.getUnadjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDates {" +
				"adjustedDate=" + this.adjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"meta=" + this.meta + ", " +
				"unadjustedDate=" + this.unadjustedDate +
			'}';
		}
	}
	
	//AdjustableDates.AdjustableDatesBuilderImpl
	class AdjustableDatesBuilderImpl implements AdjustableDates.AdjustableDatesBuilder, GlobalKeyBuilder {
	
		protected List<FieldWithMetaDateBuilder> adjustedDate = new ArrayList<>();
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<Date> unadjustedDate = new ArrayList<>();
	
		public AdjustableDatesBuilderImpl() {
		}
	
		@Override
		public List<? extends FieldWithMetaDateBuilder> getAdjustedDate() {
			return adjustedDate;
		}
		
		public FieldWithMetaDateBuilder getOrCreateAdjustedDate(int _index) {
		
			if (adjustedDate==null) {
				this.adjustedDate = new ArrayList<>();
			}
			FieldWithMetaDateBuilder result;
			return getIndex(adjustedDate, _index, () -> {
						FieldWithMetaDateBuilder newAdjustedDate = FieldWithMetaDate.builder();
						return newAdjustedDate;
					});
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
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
		public List<? extends Date> getUnadjustedDate() {
			return unadjustedDate;
		}
		
	
		@Override
		public AdjustableDates.AdjustableDatesBuilder addAdjustedDate(FieldWithMetaDate adjustedDate) {
			if (adjustedDate!=null) this.adjustedDate.add(adjustedDate.toBuilder());
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder addAdjustedDate(FieldWithMetaDate adjustedDate, int _idx) {
			getIndex(this.adjustedDate, _idx, () -> adjustedDate.toBuilder());
			return this;
		}
		
			@Override
			public AdjustableDates.AdjustableDatesBuilder addAdjustedDateValue(Date adjustedDate) {
				this.getOrCreateAdjustedDate(-1).setValue(adjustedDate);
				return this;
			}
			
			@Override
			public AdjustableDates.AdjustableDatesBuilder addAdjustedDateValue(Date adjustedDate, int _idx) {
				this.getOrCreateAdjustedDate(_idx).setValue(adjustedDate);
				return this;
			}
		@Override 
		public AdjustableDates.AdjustableDatesBuilder addAdjustedDate(List<? extends FieldWithMetaDate> adjustedDates) {
			if (adjustedDates != null) {
				for (FieldWithMetaDate toAdd : adjustedDates) {
					this.adjustedDate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AdjustableDates.AdjustableDatesBuilder setAdjustedDate(List<? extends FieldWithMetaDate> adjustedDates) {
			if (adjustedDates == null)  {
				this.adjustedDate = new ArrayList<>();
			}
			else {
				this.adjustedDate = adjustedDates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder addAdjustedDateValue(List<? extends Date> adjustedDates) {
			if (adjustedDates != null) {
				for (Date toAdd : adjustedDates) {
					this.addAdjustedDateValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder setAdjustedDateValue(List<? extends Date> adjustedDates) {
			this.adjustedDate.clear();
			if (adjustedDates!=null) {
				adjustedDates.forEach(this::addAdjustedDateValue);
			}
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		public AdjustableDates.AdjustableDatesBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(Date unadjustedDate) {
			if (unadjustedDate!=null) this.unadjustedDate.add(unadjustedDate);
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(Date unadjustedDate, int _idx) {
			getIndex(this.unadjustedDate, _idx, () -> unadjustedDate);
			return this;
		}
		@Override 
		public AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(List<? extends Date> unadjustedDates) {
			if (unadjustedDates != null) {
				for (Date toAdd : unadjustedDates) {
					this.unadjustedDate.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public AdjustableDates.AdjustableDatesBuilder setUnadjustedDate(List<? extends Date> unadjustedDates) {
			if (unadjustedDates == null)  {
				this.unadjustedDate = new ArrayList<>();
			}
			else {
				this.unadjustedDate = unadjustedDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AdjustableDates build() {
			return new AdjustableDates.AdjustableDatesImpl(this);
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDates.AdjustableDatesBuilder prune() {
			adjustedDate = adjustedDate.stream().filter(b->b!=null).<FieldWithMetaDateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedDate()!=null && !getAdjustedDate().isEmpty()) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getUnadjustedDate()!=null && !getUnadjustedDate().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDates.AdjustableDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableDates.AdjustableDatesBuilder o = (AdjustableDates.AdjustableDatesBuilder) other;
			
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::getOrCreateAdjustedDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getUnadjustedDate(), o.getUnadjustedDate(), (Consumer<Date>) this::addUnadjustedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(unadjustedDate, _that.getUnadjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDatesBuilder {" +
				"adjustedDate=" + this.adjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"meta=" + this.meta + ", " +
				"unadjustedDate=" + this.unadjustedDate +
			'}';
		}
	}
}
