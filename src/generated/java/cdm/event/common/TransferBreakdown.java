package cdm.event.common;

import cdm.event.common.TransferBase.TransferBaseBuilder;
import cdm.event.common.TransferBase.TransferBaseBuilderImpl;
import cdm.event.common.TransferBase.TransferBaseImpl;
import cdm.event.common.meta.TransferBreakdownMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface TransferBreakdown extends TransferBase {
	TransferBreakdown build();
	TransferBreakdown.TransferBreakdownBuilder toBuilder();
	
	/**
	 * The lineage into the transfer components that might be associated with each of the transfer components.
	 */
	List<? extends Lineage> getLineage();
	final static TransferBreakdownMeta metaData = new TransferBreakdownMeta();
	
	@Override
	default RosettaMetaData<? extends TransferBreakdown> metaData() {
		return metaData;
	} 
			
	static TransferBreakdown.TransferBreakdownBuilder builder() {
		return new TransferBreakdown.TransferBreakdownBuilderImpl();
	}
	
	default Class<? extends TransferBreakdown> getType() {
		return TransferBreakdown.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.event.common.TransferBase.super.process(path, processor);
		
		processRosetta(path.newSubPath("lineage"), processor, Lineage.class, getLineage());
	}
	
	
	interface TransferBreakdownBuilder extends TransferBreakdown, TransferBase.TransferBaseBuilder, RosettaModelObjectBuilder {
		Lineage.LineageBuilder getOrCreateLineage(int _index);
		List<? extends Lineage.LineageBuilder> getLineage();
		TransferBreakdown.TransferBreakdownBuilder addLineage(Lineage lineage);
		TransferBreakdown.TransferBreakdownBuilder addLineage(Lineage lineage, int _idx);
		TransferBreakdown.TransferBreakdownBuilder addLineage(List<? extends Lineage> lineage);
		TransferBreakdown.TransferBreakdownBuilder setLineage(List<? extends Lineage> lineage);
		TransferBreakdown.TransferBreakdownBuilder setIdentifier(FieldWithMetaString identifier);
		TransferBreakdown.TransferBreakdownBuilder setIdentifierValue(String identifier);
		TransferBreakdown.TransferBreakdownBuilder setTransferCalculation(TransferCalculation transferCalculation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			TransferBase.TransferBaseBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("lineage"), processor, Lineage.LineageBuilder.class, getLineage());
		}
		
	}
	
	//TransferBreakdown.TransferBreakdownImpl
	class TransferBreakdownImpl extends TransferBase.TransferBaseImpl implements TransferBreakdown {
		private final List<? extends Lineage> lineage;
		
		protected TransferBreakdownImpl(TransferBreakdown.TransferBreakdownBuilder builder) {
			super(builder);
			this.lineage = ofNullable(builder.getLineage()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends Lineage> getLineage() {
			return lineage;
		}
		
		@Override
		public TransferBreakdown build() {
			return this;
		}
		
		@Override
		public TransferBreakdown.TransferBreakdownBuilder toBuilder() {
			TransferBreakdown.TransferBreakdownBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransferBreakdown.TransferBreakdownBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLineage()).ifPresent(builder::setLineage);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TransferBreakdown _that = getType().cast(o);
		
			if (!ListEquals.listEquals(lineage, _that.getLineage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lineage != null ? lineage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferBreakdown {" +
				"lineage=" + this.lineage +
			'}' + " " + super.toString();
		}
	}
	
	//TransferBreakdown.TransferBreakdownBuilderImpl
	class TransferBreakdownBuilderImpl extends TransferBase.TransferBaseBuilderImpl  implements TransferBreakdown.TransferBreakdownBuilder {
	
		protected List<Lineage.LineageBuilder> lineage = new ArrayList<>();
	
		public TransferBreakdownBuilderImpl() {
		}
	
		@Override
		public List<? extends Lineage.LineageBuilder> getLineage() {
			return lineage;
		}
		
		public Lineage.LineageBuilder getOrCreateLineage(int _index) {
		
			if (lineage==null) {
				this.lineage = new ArrayList<>();
			}
			Lineage.LineageBuilder result;
			return getIndex(lineage, _index, () -> {
						Lineage.LineageBuilder newLineage = Lineage.builder();
						return newLineage;
					});
		}
		
	
		@Override
		public TransferBreakdown.TransferBreakdownBuilder addLineage(Lineage lineage) {
			if (lineage!=null) this.lineage.add(lineage.toBuilder());
			return this;
		}
		
		@Override
		public TransferBreakdown.TransferBreakdownBuilder addLineage(Lineage lineage, int _idx) {
			getIndex(this.lineage, _idx, () -> lineage.toBuilder());
			return this;
		}
		@Override 
		public TransferBreakdown.TransferBreakdownBuilder addLineage(List<? extends Lineage> lineages) {
			if (lineages != null) {
				for (Lineage toAdd : lineages) {
					this.lineage.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TransferBreakdown.TransferBreakdownBuilder setLineage(List<? extends Lineage> lineages) {
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
		public TransferBreakdown.TransferBreakdownBuilder setIdentifier(FieldWithMetaString identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public TransferBreakdown.TransferBreakdownBuilder setIdentifierValue(String identifier) {
			this.getOrCreateIdentifier().setValue(identifier);
			return this;
		}
		@Override
		public TransferBreakdown.TransferBreakdownBuilder setTransferCalculation(TransferCalculation transferCalculation) {
			this.transferCalculation = transferCalculation==null?null:transferCalculation.toBuilder();
			return this;
		}
		
		@Override
		public TransferBreakdown build() {
			return new TransferBreakdown.TransferBreakdownImpl(this);
		}
		
		@Override
		public TransferBreakdown.TransferBreakdownBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferBreakdown.TransferBreakdownBuilder prune() {
			super.prune();
			lineage = lineage.stream().filter(b->b!=null).<Lineage.LineageBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLineage()!=null && getLineage().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferBreakdown.TransferBreakdownBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TransferBreakdown.TransferBreakdownBuilder o = (TransferBreakdown.TransferBreakdownBuilder) other;
			
			merger.mergeRosetta(getLineage(), o.getLineage(), this::getOrCreateLineage);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TransferBreakdown _that = getType().cast(o);
		
			if (!ListEquals.listEquals(lineage, _that.getLineage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lineage != null ? lineage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferBreakdownBuilder {" +
				"lineage=" + this.lineage +
			'}' + " " + super.toString();
		}
	}
}
